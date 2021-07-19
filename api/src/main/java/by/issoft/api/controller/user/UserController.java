package by.issoft.api.controller.user;

import by.issoft.dto.PartyDto;
import by.issoft.dto.UserDto;
import by.issoft.jpa.entity.User;
import by.issoft.exception.NoEntityException;
import by.issoft.serviceModule.service.PartyService;
import by.issoft.serviceModule.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;
    private final PartyService partyService;

    public UserController(UserService userService, PartyService partyService) {
        this.userService = userService;
        this.partyService = partyService;
    }

    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> allUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserDto getById(@PathVariable Integer id) throws NoEntityException {
        return userService.findById(id);
    }

    @GetMapping(value = "/login/{login}/password/{password}")
    public UserDto getByLoginAndPassword(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password) {
       User user = new User();
       user.setLogin(login);
       user.setPassword(password);
       return userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    @GetMapping(value = "/{id}/parties")
    public List<PartyDto> getUsersParties(@PathVariable(value = "id") UserDto user) throws NoEntityException {
        List<PartyDto> parties= new ArrayList<>();
        for (Integer i : userService.getUsersParties(user)) {
            parties.add(partyService.findById(i));
        }

        return parties;
    }

    @PostMapping(value = "/{id}/add-info/{userName}/{userEmail}")
    public UserDto addInfo(@PathVariable String userName, @PathVariable String userEmail, @PathVariable(value = "id") UserDto user) {
        user.setEmail(userEmail);
        user.setName(userName);
        return userService.save(user);
    }

     @PutMapping(value = "/{id}")
    public void update(@PathVariable Integer id, UserDto user) {
        user.setId(id);
        userService.save(user);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public void addNew(@RequestBody UserDto user) {
        if (!userService.existsByLogin(user.getLogin())) {
            userService.save(user);
        }
    }

}

