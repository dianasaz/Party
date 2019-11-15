package by.iba.party.service;

import by.iba.party.entity.User;

public interface UserService extends Service<User> {
    boolean existsByLogin(String login);
}
