package by.iba.party.service;

import by.iba.party.entity.*;

import java.util.Date;
import java.util.List;

public interface PartyService extends Service<Party> {
    List<Party> findAllByAddressContains(String address);

    List<Integer> findProductsForParty(Integer id);

    List<Party> findAllByDateAfter(Date date);

    void addProductForParty(Party party, Product product);

    void deleteProductForParty(Party party, Product product);

    void addUserToParty(Party party, User user);

    boolean checkUserToParty(Party party, User user);

    Integer findCountProductsInParty(Party party, Product product);

}
