package by.issoft.jpa.repository;

import by.issoft.dto.TaskStatus;
import by.issoft.jpa.entity.Party;
import by.issoft.jpa.entity.Product;
import by.issoft.jpa.entity.Task;
import by.issoft.jpa.entity.User;
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
