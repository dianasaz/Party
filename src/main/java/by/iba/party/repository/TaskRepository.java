package by.iba.party.repository;

import by.iba.party.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Integer> {
    List<Task> findAllByParty(Party party);

    List<Task> findAllByProduct(Product product);

    List<Task> findAllByUserInfo(UserInfo userInfo);

    List<Task> findAllByStatus(TaskStatus status);

}
