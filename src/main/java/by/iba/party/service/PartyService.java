package by.iba.party.service;

import by.iba.party.entity.Party;
import by.iba.party.entity.PartyStatus;
import by.iba.party.entity.Product;

import java.util.Date;
import java.util.List;

public interface PartyService extends Service<Party> {
    List<Party> findAllByDate(Date date);

    List<Party> findAllByStatus(PartyStatus status);

    List<Party> findAllByAddressContains(String address);

    List<Integer> findProductsForParty(Integer id);

    void addProductForParty(Party party, Product product);

    void deleteProductForParty(Party party, Product product);

    Integer findCountProductsInParty(Party party, Product product);

}
