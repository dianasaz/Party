package by.iba.party.controller.product;

import by.iba.party.dto.ProductDto;
import by.iba.party.exception.NoEntityException;
import by.iba.party.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("hasAuthority('read')")
    public List<ProductDto> allProducts() {
        return productService.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ProductDto getById(@PathVariable Integer id) throws NoEntityException {
        return productService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void update(@PathVariable Integer id, @RequestBody ProductDto productDto) {
        productDto.setId(id);
        productService.save(productDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasAuthority('write')")
    public ProductDto addNew(@RequestBody ProductDto productDto) {
        return productService.save(productDto);
    }

}
