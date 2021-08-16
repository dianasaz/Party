package by.issoft.service;

import by.issoft.dto.ProductTypeDto;
import by.issoft.entity.ProductType;
import by.issoft.exception.NoEntityException;
import by.issoft.mapper.ProductTypeMapper;
import by.issoft.repository.ProductTypeRepository;
import by.issoft.serviceApi.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository, ProductTypeMapper productTypeMapper){
        this.productTypeRepository = productTypeRepository;
        this.productTypeMapper = productTypeMapper;
    }

    @Override
    public ProductTypeDto save(ProductTypeDto productTypeDto) {
        ProductType productType = productTypeMapper.fromDto(productTypeDto);
        return productTypeMapper.toDto(productTypeRepository.save(productType));
    }

    @Override
    public ProductTypeDto findById(Integer id) throws NoEntityException {
        return productTypeMapper.toDto(productTypeRepository.findById(id).orElseThrow(() -> new NoEntityException(" No product type with such id: " + id)));
    }

    @Override
    public List<ProductTypeDto> findAll() {
        return productTypeMapper.toListDto(productTypeRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        productTypeRepository.deleteById(id);
    }
}
