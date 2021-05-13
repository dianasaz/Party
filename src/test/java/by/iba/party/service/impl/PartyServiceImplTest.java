//package by.iba.party.service.impl;
//
//import by.iba.party.entity.Party;
//import by.iba.party.entity.PartyStatus;
//import by.iba.party.entity.Product;
//import by.iba.party.entity.ProductType;
//import by.iba.party.mapper.PartyMapper;
//import by.iba.party.mapper.ProductMapper;
//import by.iba.party.service.PartyService;
//import org.junit.Test;
//import org.mapstruct.factory.Mappers;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//public class PartyServiceImplTest {
//
//    PartyMapper partyMapper = Mappers.getMapper( PartyMapper.class );;
//    ProductMapper productMapper = Mappers.getMapper( ProductMapper.class );
//
//    PartyService partyService = new PartyServiceImpl();
//
//    @Test
//    public void test() {
//        Party party = new Party();
//        party.setAddress("addresssss");
//        party.setDate(new Date());
//        party.setName("nameee");
//        party.setStatus(PartyStatus.PREPARING);
//
//        Product product = new Product();
//        product.setMeasure("js");
//        product.setName("naming");
//        product.setPrice(12.4);
//        product.setType(new ProductType());
//
//        Product product1 = new Product();
//        product1.setMeasure("j");
//        product1.setName("namng");
//        product1.setPrice(11.4);
//
//        party.setProducts(new ArrayList<>());
//        party.getProducts().add(product);
//        party.getProducts().add(product1);
//
//        partyService.save(partyMapper.toDto(party));
//
//        partyService.findAll();
//
//        partyMapper.toDto(party);
//    }
//}