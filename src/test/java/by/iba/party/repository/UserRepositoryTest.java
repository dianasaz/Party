package by.iba.party.repository;

import by.iba.party.entity.Party;
import by.iba.party.entity.PartyStatus;
import by.iba.party.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;
    private PartyRepository pr;

    @Test
    @Ignore
    public void test() {
        User user = new User();
        user.setLogin("OLAKO");
        user.setPassword("1073277");
        user.setId(repository.save(user).getId());

        Party p = new Party();
        p.setAddress("abysa");
        p.setName("snja");
        p.setStatus(PartyStatus.CREATED);

        pr.findProductsForParty(9);
        System.out.println(pr.findProductsForParty(9));
    }
}