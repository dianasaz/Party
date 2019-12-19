package by.iba.party.service;

import by.iba.party.entity.User;

import java.util.List;

public interface UserService extends Service<User> {
    boolean existsByLogin(String login);

    User findByLoginAndPassword(String login, String password);

    List<Integer> getUsersParties(User user);
}
