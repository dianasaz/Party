package by.iba.party.service.impl;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.mapper.PartyMapper;
import by.iba.party.mapper.ProductMapper;
import by.iba.party.repository.PartyRepository;
import by.iba.party.service.PartyProductService;

public class PartyProductServiceImpl implements PartyProductService {
    private final PartyRepository partyRepository;
    private final PartyMapper partyMapper;
    private final ProductMapper productMapper;

    public PartyProductServiceImpl(PartyRepository partyRepository, PartyMapper partyMapper, ProductMapper productMapper) {
        this.partyRepository = partyRepository;
        this.partyMapper = partyMapper;
        this.productMapper = productMapper;
    }

    @Override
    public void addProductForParty(PartyDto partyDto, ProductDto productDto) {
        Party party = partyMapper.fromDto(partyDto);
        Product product = productMapper.fromDto(productDto);
        party.getProducts().add(product);
        partyRepository.save(party);
    }

    @Override
    public void deleteProductForParty(PartyDto partyDto, ProductDto productDto) {
        Party party = partyMapper.fromDto(partyDto);
        Product product = productMapper.fromDto(productDto);
        party.getProducts().remove(product);
        partyRepository.save(party);
    }

    @Override
    public Integer findCountProductsInParty(Integer partyId, Integer productId) {
        return partyRepository.findCountProductsInParty(partyId, productId);
    }
}
