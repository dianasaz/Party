package by.iba.party.service.impl;

import by.iba.party.entity.Party;
import by.iba.party.entity.PartyStatus;
import by.iba.party.repository.PartyRepository;
import by.iba.party.service.PartyService;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
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
    public List<Party> findAllByDate(Date date) {
        return partyRepository.findAllByDate(date);
    }

    @Override
    public List<Party> findAllByStatus(PartyStatus status) {
        return partyRepository.findAllByStatus(status);
    }

    @Override
    public List<Party> findAllByAddressContains(String address) {
        return partyRepository.findAllByAddressContains(address);
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
    public boolean existsById(Integer id) {
        return partyRepository.existsById(id);
    }

    @Override
    public List<Party> findAll() {
        return partyRepository.findAll();
    }

    @Override
    public void deleteById(Integer id) {
      //  log.log(Level.INFO, "party with id = " + id + " was deleted");
        partyRepository.deleteById(id);
    }
}
