package by.iba.party.service.impl;

import by.iba.party.dto.ProductTypeDto;
import by.iba.party.entity.ProductType;
import by.iba.party.repository.ProductTypeRepository;
import by.iba.party.service.ProductTypeService;
import by.iba.party.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeRepository productTypeRepository;

    @Autowired
    public ProductTypeServiceImpl(ProductTypeRepository productTypeRepository){
        this.productTypeRepository = productTypeRepository;
    }

    @Override
    public ProductTypeDto save(ProductTypeDto productTypeDto) {
        ProductType productType = ModelMapperUtil.map(productTypeDto, ProductType.class);
        return ModelMapperUtil.map(productTypeRepository.save(productType), ProductTypeDto.class);
    }

    @Override
    public Optional<ProductTypeDto> findById(Integer id) {
        return Optional.of(ModelMapperUtil.map(productTypeRepository.findById(id), ProductTypeDto.class));
    }

    @Override
    public List<ProductTypeDto> findAll() {
        return ModelMapperUtil.mapList(productTypeRepository.findAll(), ProductTypeDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        productTypeRepository.deleteById(id);
    }
}
