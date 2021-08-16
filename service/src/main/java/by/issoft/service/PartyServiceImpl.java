package by.issoft.service;

import by.issoft.dto.PartyDto;
import by.issoft.dto.ProductDto;
import by.issoft.dto.UserDto;
import by.issoft.entity.Party;
import by.issoft.entity.Product;
import by.issoft.entity.User;
import by.issoft.exception.NoEntityException;
import by.issoft.mapper.PartyMapper;
import by.issoft.mapper.ProductMapper;
import by.issoft.mapper.UserMapper;
import by.issoft.repository.PartyRepository;
import by.issoft.serviceApi.PartyService;
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
