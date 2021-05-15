package by.iba.party.service.impl;

import by.iba.party.dto.UserDto;
import by.iba.party.entity.User;
import by.iba.party.exception.NoEntityException;
import by.iba.party.mapper.UserMapper;
import by.iba.party.repository.UserRepository;
import by.iba.party.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean existsByLogin(String login) {
        return userRepository.existsByLogin(login);
    }

    @Override
    public UserDto findByLoginAndPassword(String login, String password) {
        return userMapper.toDto(userRepository.findByLoginAndPassword(login, password));
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = userMapper.fromDto(userDto);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public List<Integer> getUsersParties(UserDto userDto){
        return userRepository.getUsersParties(userDto.getId());
    }

    @Override
    public UserDto findById(Integer id) throws NoEntityException {
        return userMapper.toDto(userRepository.findById(id).orElseThrow(() -> new NoEntityException("No user with such id: " + id)));
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.toListDto(userRepository.findAll());
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
