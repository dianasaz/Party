package by.iba.party.service;

import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.ProductType;

import java.util.List;

public interface ProductService extends Service<Product>{
    List<Product> findAllByNameContains(String name);

    List<Product> findByPrice(Double price);

    List<Product> findAllByType(ProductType type);

    List<Product> findAllByParty(Party party);
}
