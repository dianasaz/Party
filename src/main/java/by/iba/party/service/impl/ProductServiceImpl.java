package by.iba.party.service.impl;

import by.iba.party.dto.ProductDto;
import by.iba.party.entity.Product;
import by.iba.party.mapper.ProductMapper;
import by.iba.party.repository.ProductRepository;
import by.iba.party.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.fromDto(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public Optional<ProductDto> findById(Integer id) {
        return Optional.of(productMapper.toDto(productRepository.findById(id).get()));
    }

    @Override
    public List<ProductDto> findAll() {
        return productMapper.toListDto(productRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
