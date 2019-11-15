package by.iba.party.repository;

import by.iba.party.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository  extends JpaRepository<UserInfo, Integer> {
    List<UserInfo> findAllByNameContains(String name);
}
