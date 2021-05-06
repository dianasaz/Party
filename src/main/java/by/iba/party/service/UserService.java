package by.iba.party.service;

import by.iba.party.dto.UserDto;

import java.util.List;

public interface UserService extends Service<UserDto> {
    boolean existsByLogin(String login);

    UserDto findByLoginAndPassword(String login, String password);

    List<Integer> getUsersParties(UserDto userDto);
}
