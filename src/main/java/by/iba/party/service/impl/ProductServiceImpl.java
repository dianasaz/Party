package by.iba.party.service.impl;

import by.iba.party.dto.ProductDto;
import by.iba.party.entity.Product;
import by.iba.party.repository.ProductRepository;
import by.iba.party.service.ProductService;
import by.iba.party.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = ModelMapperUtil.map(productDto, Product.class);
        return ModelMapperUtil.map(productRepository.save(product), ProductDto.class);
    }

    @Override
    public Optional<ProductDto> findById(Integer id) {
        return Optional.of(ModelMapperUtil.map(productRepository.findById(id), ProductDto.class));
    }

    @Override
    public List<ProductDto> findAll() {
        return ModelMapperUtil.mapList(productRepository.findAll(), ProductDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
