package by.iba.party.repository;

import by.iba.party.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    boolean existsByLogin(String login);

}
