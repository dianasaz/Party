package by.iba.party.service;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;

public interface PartyProductService {
    void addProductForParty(PartyDto partyDto, ProductDto productDto);

    void deleteProductForParty(PartyDto partyDto, ProductDto productDto);

    Integer findCountProductsInParty(Integer partyId, Integer productId);
}
