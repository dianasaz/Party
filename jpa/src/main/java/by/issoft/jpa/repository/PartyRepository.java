package by.issoft.jpa.repository;

import by.issoft.dto.PartyStatus;
import by.issoft.jpa.entity.Party;
import org.springframework.data.jpa.repository.JpaRepository;
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

    List<Party> findAllByDateAfter(Date date);
}
