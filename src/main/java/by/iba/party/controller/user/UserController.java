package by.iba.party.controller.user;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.UserDto;
import by.iba.party.entity.User;
import by.iba.party.service.PartyService;
import by.iba.party.service.UserService;
import lombok.extern.log4j.Log4j2;
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
@Log4j2
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
    public UserDto getById(@PathVariable Integer id) {
        return userService.findById(id).orElse(new UserDto());
    }

    @GetMapping(value = "/login/{login}/password/{password}")
    public UserDto getByLoginAndPassword(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password) {
       User user = new User();
       user.setLogin(login);
       user.setPassword(password);
       return userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
    }

    @GetMapping(value = "/{id}/parties")
    public List<PartyDto> getUsersParties(@PathVariable(value = "id") UserDto user){
        List<PartyDto> parties= new ArrayList<>();
        for (Integer i : userService.getUsersParties(user)) {
            parties.add(partyService.findById(i).get());
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

