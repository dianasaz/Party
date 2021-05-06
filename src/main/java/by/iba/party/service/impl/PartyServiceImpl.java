package by.iba.party.service.impl;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.UserDto;
import by.iba.party.entity.Party;
import by.iba.party.entity.Product;
import by.iba.party.entity.User;
import by.iba.party.repository.PartyRepository;
import by.iba.party.service.PartyService;
import by.iba.party.util.ModelMapperUtil;
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
    public List<PartyDto> findAllByAddressContains(String address) {
        return ModelMapperUtil.mapList(partyRepository.findAllByAddressContains(address), PartyDto.class);
    }

    @Override
    public List<Integer> findProductsForParty(Integer id) {
        return partyRepository.findProductsForParty(id);
    }

    @Override
    public List<PartyDto> findAllByDateAfter(Date date) {
        return ModelMapperUtil.mapList(partyRepository.findAllByDateAfter(date), PartyDto.class);
    }

    @Override
    public void addProductForParty(PartyDto partyDto, ProductDto productDto) {
        Party party = ModelMapperUtil.map(partyDto, Party.class);
        Product product = ModelMapperUtil.map(productDto, Product.class);
        party.getProducts().add(product);
        partyRepository.save(party);
    }

    @Override
    public void deleteProductForParty(PartyDto partyDto, ProductDto productDto) {
        Party party = ModelMapperUtil.map(partyDto, Party.class);
        Product product = ModelMapperUtil.map(productDto, Product.class);
        party.getProducts().remove(product);
        partyRepository.save(party);
    }

    @Override
    public void addUserToParty(PartyDto partyDto, UserDto userDto) {
        Party party = ModelMapperUtil.map(partyDto, Party.class);
        User user = ModelMapperUtil.map(userDto, User.class);
        party.getUsers().add(user);
        partyRepository.save(party);
    }

    @Override
    public boolean checkUserToParty(PartyDto partyDto, UserDto userDto) {
        return partyDto.getUserDtos().contains(userDto);
    }

    @Override
    public Integer findCountProductsInParty(PartyDto partyDto, ProductDto productDto) {
        return partyRepository.findCountProductsInParty(partyDto.getId(), productDto.getId());
    }

    @Override
    public PartyDto save(PartyDto entity) {
        Party party = ModelMapperUtil.map(entity, Party.class);
        return ModelMapperUtil.map(partyRepository.save(party), PartyDto.class);
    }

    @Override
    public Optional<PartyDto> findById(Integer id) {
        return Optional.of(ModelMapperUtil.map(partyRepository.findById(id), PartyDto.class));
    }

    @Override
    public List<PartyDto> findAll() {
        return ModelMapperUtil.mapList(partyRepository.findAll(), PartyDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        partyRepository.deleteById(id);
    }
}
