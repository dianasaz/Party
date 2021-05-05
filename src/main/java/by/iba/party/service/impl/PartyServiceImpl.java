package by.iba.party.service.impl;

import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.User;
import by.iba.party.repository.PartyRepository;
import by.iba.party.service.PartyService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;

    @Autowired
    public PartyServiceImpl(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    @Override
    public List<Party> findAllByAddressContains(String address) {
        return partyRepository.findAllByAddressContains(address);
    }

    @Override
    public List<Integer> findProductsForParty(Integer id) {
        return partyRepository.findProductsForParty(id);
    }

    @Override
    public List<Party> findAllByDateAfter(Date date) {
        return partyRepository.findAllByDateAfter(date);
    }

    @Override
    public void addProductForParty(Party party, Product product) {
        party.getProducts().add(product);
        partyRepository.save(party);
    }

    @Override
    public void deleteProductForParty(Party party, Product product) {
        party.getProducts().remove(product);
        partyRepository.save(party);
    }

    @Override
    public void addUserToParty(Party party, User user) {
        party.getUsers().add(user);
        partyRepository.save(party);
    }

    @Override
    public boolean checkUserToParty(Party party, User user) {
        return party.getUsers().contains(user);
    }

    @Override
    public Integer findCountProductsInParty(Party party, Product product) {
        return partyRepository.findCountProductsInParty(party.getId(), product.getId());
    }

    @Override
    public Party save(Party entity) {
        return partyRepository.save(entity);
    }

    @Override
    public Optional<Party> findById(Integer id) {
        return partyRepository.findById(id);
    }

    @Override
    public List<Party> findAll() {
        return partyRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        partyRepository.deleteById(id);
    }
}
