package by.iba.party.service.impl;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.UserDto;
import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.User;
import by.iba.party.exception.NoEntityException;
import by.iba.party.mapper.PartyMapper;
import by.iba.party.mapper.ProductMapper;
import by.iba.party.mapper.UserMapper;
import by.iba.party.repository.PartyRepository;
import by.iba.party.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PartyServiceImpl implements PartyService {
    private final PartyRepository partyRepository;
    private final PartyMapper partyMapper;
    private final UserMapper userMapper;
    private final ProductMapper productMapper;

    @Autowired
    public PartyServiceImpl(PartyRepository partyRepository, PartyMapper partyMapper, UserMapper userMapper, ProductMapper productMapper) {
        this.partyRepository = partyRepository;
        this.partyMapper = partyMapper;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }

    @Override
    public List<PartyDto> findAllByAddressContains(String address) {
        return partyMapper.toListDto(partyRepository.findAllByAddressContains(address));
    }

    @Override
    public List<Integer> findProductsForParty(Integer id) {
        return partyRepository.findProductsForParty(id);
    }

    @Override
    public List<PartyDto> findAllByDateAfter(Date date) {
        return partyMapper.toListDto(partyRepository.findAllByDateAfter(date));
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
    public void addUserToParty(PartyDto partyDto, UserDto userDto) {
        Party party = partyMapper.fromDto(partyDto);
        User user = userMapper.fromDto(userDto);
        party.getUsers().add(user);
        partyRepository.save(party);
    }

    @Override
    public Integer findCountProductsInParty(Integer partyId, Integer productId) {
        return partyRepository.findCountProductsInParty(partyId, productId);
    }

    @Override
    public PartyDto save(PartyDto partyDto) {
        Party party = partyMapper.fromDto(partyDto);
        return partyMapper.toDto(partyRepository.save(party));
    }

    @Override
    public PartyDto findById(Integer id) throws NoEntityException {
        return partyMapper.toDto(partyRepository.findById(id).orElseThrow(() -> new NoEntityException(" No party with such id: " + id)));
    }

    @Override
    public List<PartyDto> findAll() {
        return partyMapper.toListDto(partyRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        partyRepository.deleteById(id);
    }
}
