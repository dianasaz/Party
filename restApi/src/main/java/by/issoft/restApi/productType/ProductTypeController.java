package by.issoft.restApi.productType;

import by.issoft.exception.NoEntityException;
import by.issoft.restModel.ProductTypeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping(value = "/product-types")
public interface ProductTypeController {

    @GetMapping(value = "/all")
    List<ProductTypeResponse> allProductTypes();

    @GetMapping(value = "/{id}")
    ProductTypeResponse getById(@PathVariable Integer id) throws NoEntityException ;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void update(@PathVariable Integer id, @RequestBody ProductTypeResponse newProductTypeResponse);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable Integer id);

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    void addNew(@RequestBody ProductTypeResponse productTypeResponse);
}
