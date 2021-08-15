package by.issoft.repository;

import by.issoft.entity.Party;
import by.issoft.entity.Product;
import by.issoft.entity.Task;
import by.issoft.entity.TaskStatus;
import by.issoft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository  extends JpaRepository<Task, Integer> {
    List<Task> findAllByParty(Party party);

    List<Task> findAllByProduct(Product product);

    List<Task> findAllByUser(User user);

    List<Task> findAllByStatus(TaskStatus status);

    Task findByPartyAndProduct(Party party, Product product);

    List<Task> findAllByUserAndParty(User user, Party party);

}
