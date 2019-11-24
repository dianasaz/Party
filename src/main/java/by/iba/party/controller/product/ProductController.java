package by.iba.party.controller.product;

import by.iba.party.entity.Product;
import by.iba.party.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/products/")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/all")
    public List<Product> allProducts() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Product getById(@PathVariable Integer id) {
        return productService.findById(id).orElse(new Product());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody Product product) {
        product.setId(id);
        productService.save(product);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void addNew(@RequestBody Product product) {
        productService.save(product);
    }

}
