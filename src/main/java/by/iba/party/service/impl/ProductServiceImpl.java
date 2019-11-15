package by.iba.party.service.impl;

import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.ProductType;
import by.iba.party.repository.ProductRepository;
import by.iba.party.service.ProductService;
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
    public List<Product> findAllByNameContains(String name) {
        return productRepository.findAllByNameContains(name);
    }

    @Override
    public List<Product> findByPrice(Double price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public List<Product> findAllByType(ProductType type) {
        return productRepository.findAllByType(type);
    }

    @Override
    public List<Product> findAllByParty(Party party) {
        return productRepository.findAllByParty(party);
    }

    @Override
    public Product save(Product entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return productRepository.existsById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        productRepository.deleteById(id);
    }
}
