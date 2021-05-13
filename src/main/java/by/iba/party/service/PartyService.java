package by.iba.party.service;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.UserDto;

import java.util.Date;
import java.util.List;

public interface PartyService extends Service<PartyDto> {
    List<PartyDto> findAllByAddressContains(String address);

    List<Integer> findProductsForParty(Integer id);

    List<PartyDto> findAllByDateAfter(Date date);

    void addProductForParty(PartyDto partyDto, ProductDto productDto);

    void deleteProductForParty(PartyDto partyDto, ProductDto productDto);

    void addUserToParty(PartyDto partyDto, UserDto userDto);

    Integer findCountProductsInParty(Integer partyId, Integer productId);

}
