package by.iba.party.repository;

import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAllByNameContains(String name);

    List<Product> findByPrice(Double price);

    List<Product> findAllByType(ProductType type);

}
