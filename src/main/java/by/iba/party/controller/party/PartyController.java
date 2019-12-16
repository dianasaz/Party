package by.iba.party.controller.party;

import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.service.PartyService;
import by.iba.party.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/parties")
public class PartyController {
    private final PartyService partyService;
    private final ProductService productService;

    @Autowired
    public PartyController(PartyService partyService, ProductService productService) {
        this.partyService = partyService;
        this.productService = productService;
    }

    @GetMapping(value = "/all")
    public List<Party> allParties() {
        return partyService.findAll();
    }

    @GetMapping(value = "/by-address")
    public List<Party> allPartiesByAddress(@RequestBody String address) {
        return partyService.findAllByAddressContains(address);
    }

    @GetMapping(value = "/{id}")
    public Party getById(@PathVariable Integer id) {
        return partyService.findById(id).orElse(new Party());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody Party party) {
        party.setId(id);
        partyService.save(party);
    }

    @GetMapping(value = "/{id}/products")
    public List<Product> allProductsForParty(@PathVariable(value = "id") Integer id) {
        List<Integer> prod_ids = partyService.findProductsForParty(id);
//        List<Product> products = new ArrayList<>();
//        for (Integer i : prod_ids) {
//            productService.findById(i).ifPresent(product -> products.add(product));
//        }
//        return products;
        return prod_ids.stream()
                .map(productService::findById)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/{party_id}/products/{product_id}")
    public Integer findCountOfProductOnParty(@PathVariable(value = "party_id") Party party, @PathVariable(value = "product_id") Product product) {
        return partyService.findCountProductsInParty(party, product);
    }

    @PostMapping(value = "/{party_id}/add/product/{product_id}")
    public void addProductForParty(@PathVariable(value = "party_id") Party party, @PathVariable(value = "product_id") Product product) {
        partyService.addProductForParty(party, product);
    }

    @DeleteMapping(value = "/{party_id}/delete/product/{product_id}")
    public void deleteProductForParty(@PathVariable(value = "party_id") Party party, @PathVariable(value = "product_id") Product product) {
        partyService.deleteProductForParty(party, product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        partyService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void addNew(@RequestBody Party party) {
        partyService.save(party);
    }

}
