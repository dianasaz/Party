package by.issoft.serviceModule.service.impl;

import by.issoft.jpa.entity.Product;
import by.issoft.exception.NoEntityException;
import by.issoft.serviceModule.mapper.ProductMapper;
import by.issoft.jpa.repository.ProductRepository;
import by.issoft.serviceModule.service.ProductService;
import by.issoft.dto.ProductDto;
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
