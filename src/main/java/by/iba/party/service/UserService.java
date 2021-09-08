package by.iba.party.service;

import by.iba.party.dto.UserDto;
import by.iba.party.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends Service<UserDto> {
    boolean existsByLogin(String login);

    UserDto findByLoginAndPassword(String login, String password);

    List<Integer> getUsersParties(UserDto userDto);

    UserDto findByLogin(String login);
}
