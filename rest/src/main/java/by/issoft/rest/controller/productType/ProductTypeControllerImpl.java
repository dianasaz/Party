package by.issoft.rest.controller.productType;

import by.issoft.exception.NoEntityException;
import by.issoft.restApi.productType.ProductTypeController;
import by.issoft.restMapper.ProductTypeResponseMapper;
import by.issoft.restModel.ProductTypeResponse;
import by.issoft.serviceApi.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductTypeControllerImpl implements ProductTypeController {
    private final ProductTypeService productTypeService;
    private final ProductTypeResponseMapper productTypeResponseMapper;

    @Autowired
    public ProductTypeControllerImpl(ProductTypeService productTypeService, ProductTypeResponseMapper productTypeResponseMapper) {
        this.productTypeService = productTypeService;
        this.productTypeResponseMapper = productTypeResponseMapper;
    }

    public List<ProductTypeResponse> allProductTypes() {
        return productTypeResponseMapper.fromListDto(productTypeService.findAll());
    }

    public ProductTypeResponse getById(Integer id) throws NoEntityException {
        return productTypeResponseMapper.fromDto(productTypeService.findById(id));
    }

    public void update(Integer id, ProductTypeResponse newType) {
        newType.setId(id);
        productTypeService.save(productTypeResponseMapper.toDto(newType));
    }

    public void delete(Integer id) {
        productTypeService.deleteById(id);
    }

    public void addNew(ProductTypeResponse productTypeResponse) {
        productTypeService.save(productTypeResponseMapper.toDto(productTypeResponse));
    }

}
