package by.iba.party.repository;

import by.iba.party.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository  extends JpaRepository<ProductType, Integer> {
}
