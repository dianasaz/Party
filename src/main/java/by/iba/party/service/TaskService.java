package by.iba.party.service;

import by.iba.party.entity.*;

import java.util.List;

public interface TaskService extends Service<Task> {
    List<Task> findAllByUser(User userInfo);

    Task checkExistTask(Party party, Product product);

    List<Task> findAllByUserAndParty(User user, Party party);


}
