package by.iba.party.service.impl;

import by.iba.party.dto.ProductDto;
import by.iba.party.entity.Product;
import by.iba.party.exception.NoEntityException;
import by.iba.party.mapper.ProductMapper;
import by.iba.party.repository.ProductRepository;
import by.iba.party.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = productMapper.fromDto(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto findById(Integer id) throws NoEntityException {
        return productMapper.toDto(productRepository.findById(id).orElseThrow(() -> new NoEntityException(" No product with such id: " + id)));
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
