package by.iba.party.repository;

import by.iba.party.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    boolean existsByLogin(String login);

    User findByLoginAndPassword(String login, String password);

    @Query(nativeQuery = true, value = "select party_id from party_users where users_id=:user_id")
    List<Integer> getUsersParties(@Param("user_id")Integer user_id);

}
