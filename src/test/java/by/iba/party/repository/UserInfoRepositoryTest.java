package by.iba.party.repository;

import by.iba.party.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class UserInfoRepositoryTest {
    @Autowired
    private UserInfoRepository repository;

    @Test
    public void test(){
        UserInfo userInfo = new UserInfo();
        userInfo.setName("Privet Medved");
        userInfo.setId(repository.save(userInfo).getId());

        UserInfo second = new UserInfo();
        second.setName("Privet Andrey");
        second.setId(repository.save(second).getId());

        Assert.assertEquals(2, repository.findAllByNameContains("Privet").size());

    }

}