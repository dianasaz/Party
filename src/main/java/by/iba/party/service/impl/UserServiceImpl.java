package by.iba.party.service.impl;

import by.iba.party.dto.UserDto;
import by.iba.party.entity.User;
import by.iba.party.repository.UserRepository;
import by.iba.party.service.UserService;
import by.iba.party.util.ModelMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

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
        return ModelMapperUtil.map(userRepository.findByLoginAndPassword(login, password), UserDto.class);
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = ModelMapperUtil.map(userDto, User.class);
        return ModelMapperUtil.map(userRepository.save(user), UserDto.class);
    }

    @Override
    public List<Integer> getUsersParties(UserDto userDto){
        return userRepository.getUsersParties(userDto.getId());
    }

    @Override
    public Optional<UserDto> findById(Integer id) {
        return Optional.of(ModelMapperUtil.map(userRepository.findById(id), UserDto.class));
    }

    @Override
    public List<UserDto> findAll() {
        return ModelMapperUtil.mapList(userRepository.findAll(), UserDto.class);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
