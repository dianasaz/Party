package by.issoft.rest.controller.user;

import by.issoft.dto.PartyDto;
import by.issoft.exception.NoEntityException;
import by.issoft.restApi.user.UserController;
import by.issoft.restMapper.PartyResponseMapper;
import by.issoft.restMapper.UserResponseMapper;
import by.issoft.restModel.PartyResponse;
import by.issoft.restModel.UserResponse;
import by.issoft.serviceApi.PartyService;
import by.issoft.serviceApi.UserService;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserControllerImpl implements UserController {
    private final UserService userService;
    private final PartyService partyService;
    private final UserResponseMapper userResponseMapper;
    private final PartyResponseMapper partyResponseMapper;

    public UserControllerImpl(UserService userService, PartyService partyService, UserResponseMapper userResponseMapper, PartyResponseMapper partyResponseMapper) {
        this.userService = userService;
        this.partyService = partyService;
        this.userResponseMapper = userResponseMapper;
        this.partyResponseMapper = partyResponseMapper;
    }

    public List<UserResponse> allUsers() {
        return userResponseMapper.fromListDto(userService.findAll());
    }

    public UserResponse getById(Integer id) throws NoEntityException {
        return userResponseMapper.fromDto(userService.findById(id));
    }

    public UserResponse getByLoginAndPassword(String login, String password) {
        UserResponse user = new UserResponse();
        user.setLogin(login);
        user.setPassword(password);
        return userResponseMapper.fromDto(userService.findByLoginAndPassword(user.getLogin(), user.getPassword()));
    }

    public List<PartyResponse> getUsersParties(UserResponse user) throws NoEntityException {
        List<PartyDto> parties = new ArrayList<>();
        for (Integer i : userService.getUsersParties(userResponseMapper.toDto(user))) {
            parties.add(partyService.findById(i));
        }

        return partyResponseMapper.fromListDto(parties);
    }

    public UserResponse addInfo(String userName, String userEmail, UserResponse user) {
        user.setEmail(userEmail);
        user.setName(userName);
        return userResponseMapper.fromDto(userService.save(userResponseMapper.toDto(user)));
    }

    public void update(Integer id, UserResponse user) {
        user.setId(id);
        userService.save(userResponseMapper.toDto(user));
    }

    public void delete(Integer id) {
        userService.deleteById(id);
    }

    public void addNew(UserResponse user) {
        if (!userService.existsByLogin(user.getLogin())) {
            userService.save(userResponseMapper.toDto(user));
        }
    }

}

