package by.iba.party.controller.productType;

import by.iba.party.entity.ProductType;
import by.iba.party.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product-types")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping(value = "/all")
    public List<ProductType> allProductTypes() {
        return productTypeService.findAll();
    }

    @GetMapping(value = "/{id}")
    public ProductType getById(@PathVariable Integer id) {
        return productTypeService.findById(id).orElse(new ProductType());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody ProductType newType) {
        newType.setId(id);
        productTypeService.save(newType);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        productTypeService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void addNew(@RequestBody ProductType productType) {
        productTypeService.save(productType);
    }

}
