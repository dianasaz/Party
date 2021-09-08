package by.iba.party.controller.productType;

import by.iba.party.dto.ProductTypeDto;
import by.iba.party.exception.NoEntityException;
import by.iba.party.service.ProductTypeService;
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
@RequestMapping(value = "/product-types")
public class ProductTypeController {
    private final ProductTypeService productTypeService;

    @Autowired
    public ProductTypeController(ProductTypeService productTypeService) {
        this.productTypeService = productTypeService;
    }

    @GetMapping
    public List<ProductTypeDto> allProductTypes() {
        return productTypeService.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('read')")
    public ProductTypeDto getById(@PathVariable Integer id) throws NoEntityException {
        return productTypeService.findById(id);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void update(@PathVariable Integer id, @RequestBody ProductTypeDto newTypeDto) {
        newTypeDto.setId(id);
        productTypeService.save(newTypeDto);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void delete(@PathVariable Integer id) {
        productTypeService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasAuthority('write')")
    public void addNew(@RequestBody ProductTypeDto productTypeDto) {
        productTypeService.save(productTypeDto);
    }

}
