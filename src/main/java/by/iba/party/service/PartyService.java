package by.iba.party.service;

import by.iba.party.entity.Party;
import by.iba.party.entity.PartyStatus;

import java.util.Date;
import java.util.List;

public interface PartyService extends Service<Party> {
    List<Party> findAllByDate(Date date);

    List<Party> findAllByStatus(PartyStatus status);

    List<Party> findAllByAddressContains(String address);
}
