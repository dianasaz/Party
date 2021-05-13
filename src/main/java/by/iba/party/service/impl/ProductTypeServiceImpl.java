package by.iba.party.service.impl;

import by.iba.party.dto.ProductTypeDto;
import by.iba.party.entity.ProductType;
import by.iba.party.mapper.ProductTypeMapper;
import by.iba.party.repository.ProductTypeRepository;
import by.iba.party.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;
    private final ProductTypeMapper productTypeMapper = ProductTypeMapper.INSTANCE;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository){
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductTypeDto save(ProductTypeDto productTypeDto) {
        ProductType productType = productTypeMapper.fromDto(productTypeDto);
        return productTypeMapper.toDto(productTypeRepository.save(productType));
    }

    @Override
    public Optional<ProductTypeDto> findById(Integer id) {
        return Optional.of(productTypeMapper.toDto(productTypeRepository.findById(id).get()));
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
