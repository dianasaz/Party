package by.issoft.rest.controller.product;

import by.issoft.exception.NoEntityException;
import by.issoft.restApi.product.ProductController;
import by.issoft.restMapper.ProductResponseMapper;
import by.issoft.restModel.ProductResponse;
import by.issoft.serviceApi.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductControllerImpl implements ProductController {
    private final ProductService productService;
    private final ProductResponseMapper productResponseMapper;

    @Autowired
    public ProductControllerImpl(ProductService productService, ProductResponseMapper productResponseMapper) {
        this.productService = productService;
        this.productResponseMapper = productResponseMapper;
    }

    public List<ProductResponse> allProducts() {
        return productResponseMapper.fromListDto(productService.findAll());
    }

    public ProductResponse getById(Integer id) throws NoEntityException {
        return productResponseMapper.fromDto(productService.findById(id));
    }

    public void update(Integer id, ProductResponse productResponse) {
        productResponse.setId(id);
        productService.save(productResponseMapper.toDto(productResponse));
    }

    public void delete(Integer id) {
        productService.deleteById(id);
    }

    public ProductResponse addNew(ProductResponse productResponse) {
        return productResponseMapper.fromDto(productService.save(productResponseMapper.toDto(productResponse)));
    }

}
