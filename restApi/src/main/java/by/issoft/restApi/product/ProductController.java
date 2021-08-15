package by.issoft.restApi.product;

import by.issoft.exception.NoEntityException;
import by.issoft.restModel.ProductResponse;
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

@RequestMapping (value = "/products")
public interface ProductController {
    @GetMapping(value = "/all")
    List<ProductResponse> allProducts();

    @GetMapping(value = "/{id}")
    ProductResponse getById(@PathVariable Integer id) throws NoEntityException;

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void update(@PathVariable Integer id, @RequestBody ProductResponse productResponse);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void delete(@PathVariable Integer id);

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    ProductResponse addNew(@RequestBody ProductResponse productResponse);

}
