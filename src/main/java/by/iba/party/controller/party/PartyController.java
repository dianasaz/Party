package by.iba.party.controller.party;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.TaskDto;
import by.iba.party.dto.UserDto;
import by.iba.party.exception.NoEntityException;
import by.iba.party.service.PartyProductService;
import by.iba.party.service.PartyService;
import by.iba.party.service.ProductService;
import by.iba.party.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/parties")
public class PartyController {
    private final PartyService partyService;
    private final ProductService productService;
    private final TaskService taskService;
    private final PartyProductService partyProductService;

    @Autowired
    public PartyController(PartyService partyService, ProductService productService, TaskService taskService, PartyProductService partyProductService) {
        this.partyService = partyService;
        this.productService = productService;
        this.taskService = taskService;
        this.partyProductService = partyProductService;
    }

    @GetMapping(value = "/all")
    public List<PartyDto> allParties() {
        return partyService.findAllByDateAfter(new Date());
    }

    @GetMapping(value = "/by-address")
    public List<PartyDto> allPartiesByAddress(@RequestBody String address) {
        return partyService.findAllByAddressContains(address);
    }

    @GetMapping(value = "/{id}")
    public PartyDto  getById(@PathVariable Integer id) throws NoEntityException {
        return partyService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody PartyDto partyDto) {
        partyDto.setId(id);
        partyService.save(partyDto);
    }

    @GetMapping(value = "/{id}/products")
    public List<ProductDto> allProductsForParty(@PathVariable(value = "id") Integer id) {
        List<Integer> productIds = partyService.findProductsForParty(id);
        return productIds.stream()
                .map(this::findProductById)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{party_id}/products/{product_id}")
    public Integer findCountOfProductOnParty(@PathVariable(value = "party_id") Integer partyId, @PathVariable(value = "product_id") Integer productId) {
        return partyProductService.findCountProductsInParty(partyId, productId);
    }

    @PostMapping(value = "/{party_id}/add/product/{product_id}")
    public void addProductForParty(@PathVariable(value = "party_id") PartyDto partyDto, @PathVariable(value = "product_id") ProductDto productDto) {
        TaskDto taskDto = taskService.checkExistTask(partyDto, productDto);
        if (taskDto != null) {
            taskDto.setQuantity(taskDto.getQuantity() + 1);
            taskService.save(taskDto);
        }
        partyProductService.addProductForParty(partyDto, productDto);
    }

    @DeleteMapping(value = "/{party_id}/delete/product/{product_id}")
    public void deleteProductForParty(@PathVariable(value = "party_id") PartyDto partyDto, @PathVariable(value = "product_id") ProductDto productDto) {
        TaskDto taskDto = taskService.checkExistTask(partyDto, productDto);
        if (taskDto != null) {
            if (taskDto.getQuantity() != 1) {
                taskDto.setQuantity(taskDto.getQuantity() - 1);
                taskService.save(taskDto);
            }
            if (taskDto.getQuantity() == 1) {
                productService.deleteById(productDto.getId());
            }
        }
        partyProductService.deleteProductForParty(partyDto, productDto);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        partyService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public PartyDto addNew(@RequestBody PartyDto partyDto) {
        return partyService.save(partyDto);
    }

    @PostMapping(value = "/{party_id}/add/user/{user_id}")
    public void addUserToParty(@PathVariable(value = "party_id") PartyDto partyDto, @PathVariable(value = "user_id") UserDto userInfoDto) {
        partyService.addUserToParty(partyDto, userInfoDto);
    }

    @GetMapping(value = "/{party_id}/users")
    public List<UserDto> getAllUsersOnTHisParty(@PathVariable(value = "party_id") Integer id) throws NoEntityException {
        return partyService.findById(id).getUsers();
    }

    private ProductDto findProductById(Integer id) {
        try {
            return productService.findById(id);
        }
        catch (NoEntityException e) {
            log.debug("No product with ID: {} exists", id, e);
        }
        return null;
    }
}
