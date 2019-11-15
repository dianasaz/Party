package by.iba.party.service;

import by.iba.party.entity.*;

import java.util.List;

public interface TaskService extends Service<Task> {
    List<Task> findAllByParty(Party party);

    List<Task> findAllByProduct(Product product);

    List<Task> findAllByUserInfo(UserInfo userInfo);

    List<Task> findAllByStatus(TaskStatus status);
}
