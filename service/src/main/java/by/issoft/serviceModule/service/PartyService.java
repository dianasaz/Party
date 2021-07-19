package by.issoft.serviceModule.service;

import by.issoft.dto.PartyDto;
import by.issoft.dto.ProductDto;
import by.issoft.dto.UserDto;

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
