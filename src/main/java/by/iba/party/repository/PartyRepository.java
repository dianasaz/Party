package by.iba.party.repository;

import by.iba.party.entity.Party;
import by.iba.party.entity.PartyStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    List<Party> findAllByDate(Date date);

    List<Party> findAllByStatus(PartyStatus status);

    List<Party> findAllByAddressContains(String address);
}
