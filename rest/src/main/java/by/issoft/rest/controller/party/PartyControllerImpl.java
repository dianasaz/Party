package by.issoft.rest.controller.party;

import by.issoft.dto.ProductDto;
import by.issoft.dto.TaskDto;
import by.issoft.exception.NoEntityException;
import by.issoft.restApi.party.PartyController;
import by.issoft.restMapper.PartyResponseMapper;
import by.issoft.restMapper.ProductResponseMapper;
import by.issoft.restMapper.UserResponseMapper;
import by.issoft.restModel.PartyResponse;
import by.issoft.restModel.ProductResponse;
import by.issoft.restModel.UserResponse;
import by.issoft.serviceApi.PartyService;
import by.issoft.serviceApi.ProductService;
import by.issoft.serviceApi.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
public class PartyControllerImpl implements PartyController {
    private final PartyService partyService;
    private final ProductService productService;
    private final TaskService taskService;
    private final PartyResponseMapper partyResponseMapper;
    private final ProductResponseMapper productResponseMapper;
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public PartyControllerImpl(PartyService partyService, ProductService productService, TaskService taskService, PartyResponseMapper partyResponseMapper, ProductResponseMapper productResponseMapper, UserResponseMapper userResponseMapper) {
        this.partyService = partyService;
        this.productService = productService;
        this.taskService = taskService;
        this.partyResponseMapper = partyResponseMapper;
        this.productResponseMapper = productResponseMapper;
        this.userResponseMapper = userResponseMapper;
    }

    public List<PartyResponse> allParties() {
        return partyResponseMapper.fromListDto(partyService.findAllByDateAfter(new Date()));
    }

    public List<PartyResponse> allPartiesByAddress(String address) {
        return partyResponseMapper.fromListDto(partyService.findAllByAddressContains(address));
    }

    public PartyResponse  getById(Integer id) throws NoEntityException {
        return partyResponseMapper.fromDto(partyService.findById(id));
    }

    public void update(Integer id, PartyResponse PartyResponse) {
        PartyResponse.setId(id);
        partyService.save(partyResponseMapper.toDto(PartyResponse));
    }

    public List<ProductResponse> allProductsForParty(Integer id) {
        List<Integer> productIds = partyService.findProductsForParty(id);
        return productResponseMapper.fromListDto(productIds.stream()
                .map(this::findProductById)
                .collect(Collectors.toList()));
    }

    public Integer findCountOfProductOnParty(Integer partyId, Integer productId) {
        return partyService.findCountProductsInParty(partyId, productId);
    }

    public void addProductForParty(PartyResponse partyResponse, ProductResponse productResponse) {
        TaskDto taskDto = taskService.checkExistTask(partyResponseMapper.toDto(partyResponse), productResponseMapper.toDto(productResponse));
        if (taskDto != null) {
            taskDto.setQuantity(taskDto.getQuantity() + 1);
            taskService.save(taskDto);
        }
        partyService.addProductForParty(partyResponseMapper.toDto(partyResponse), productResponseMapper.toDto(productResponse));
    }

    public void deleteProductForParty(PartyResponse partyResponse, ProductResponse productResponse) {
        TaskDto taskDto = taskService.checkExistTask(partyResponseMapper.toDto(partyResponse), productResponseMapper.toDto(productResponse));
        if (taskDto != null) {
            if (taskDto.getQuantity() != 1) {
                taskDto.setQuantity(taskDto.getQuantity() - 1);
                taskService.save(taskDto);
            }
            if (taskDto.getQuantity() == 1) {
                productService.deleteById(productResponse.getId());
            }
        }
        partyService.deleteProductForParty(partyResponseMapper.toDto(partyResponse), productResponseMapper.toDto(productResponse));
    }

    public void delete(Integer id) {
        partyService.deleteById(id);
    }

    public PartyResponse addNew(PartyResponse partyResponse) {
        return partyResponseMapper.fromDto(partyService.save(partyResponseMapper.toDto(partyResponse)));
    }

    public void addUserToParty(PartyResponse partyResponse, UserResponse userInfoResponse) {
        partyService.addUserToParty(partyResponseMapper.toDto(partyResponse), userResponseMapper.toDto(userInfoResponse));
    }

    public List<UserResponse> getAllUsersOnTHisParty(Integer id) throws NoEntityException {
        return userResponseMapper.fromListDto(partyService.findById(id).getUsers());
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
