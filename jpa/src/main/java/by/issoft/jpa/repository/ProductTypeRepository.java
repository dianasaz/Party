package by.issoft.jpa.repository;

import by.issoft.jpa.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository  extends JpaRepository<ProductType, Integer> {
}
