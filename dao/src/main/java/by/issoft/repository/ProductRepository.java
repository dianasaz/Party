package by.issoft.repository;

import by.issoft.entity.Product;
import by.issoft.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByNameContains(String name);

    List<Product> findByPrice(Double price);

    List<Product> findAllByType(ProductType type);

}
