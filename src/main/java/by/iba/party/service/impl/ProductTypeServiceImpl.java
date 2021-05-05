package by.iba.party.service.impl;

import by.iba.party.entity.ProductType;
import by.iba.party.repository.ProductTypeRepository;
import by.iba.party.service.ProductTypeService;
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
    public ProductType save(ProductType entity) {
        return productTypeRepository.save(entity);
    }

    @Override
    public Optional<ProductType> findById(Integer id) {
        return productTypeRepository.findById(id);
    }

    @Override
    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        productTypeRepository.deleteById(id);
    }
}
