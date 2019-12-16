package by.iba.party.repository;

import by.iba.party.entity.Party;
import by.iba.party.entity.PartyStatus;
import by.iba.party.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
    List<Party> findAllByDate(Date date);

    List<Party> findAllByStatus(PartyStatus status);

    List<Party> findAllByAddressContains(String address);

    @Query(nativeQuery = true, value = "select distinct products_id from party_products where party_id = :party_id")
    List<Integer> findProductsForParty(@Param("party_id") Integer id);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) FROM party_products WHERE party_id = :party_id AND products_id = :product_id")
    Integer findCountProductsInParty(@Param("party_id") Integer partyId, @Param("product_id") Integer productId);

//    @Query (nativeQuery = true, value = "insert into party_products (party_id, products_id) values (:party, :product)")
//    void addProductForParty(@Param("party") Integer party,@Param("product") Integer product);
}
