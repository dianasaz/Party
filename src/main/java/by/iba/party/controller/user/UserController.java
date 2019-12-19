package by.iba.party.controller.user;

import by.iba.party.entity.Party;
import by.iba.party.entity.User;
import by.iba.party.service.PartyService;
import by.iba.party.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public List<User> allUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User getById(@PathVariable Integer id) {
        return userService.findById(id).orElse(new User());
    }

    @GetMapping(value = "/login/{login}/password/{password}")
    public User getByLoginAndPassword(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password) {
       User user = new User();
       user.setLogin(login);
       user.setPassword(password);
        User u = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
        return u;
    }

    @GetMapping(value = "/{id}/parties")
    public List<Party> getUsersParties(@PathVariable(value = "id") User user){
        List<Party> parties= new ArrayList<>();
        for (Integer i : userService.getUsersParties(user)) {
            parties.add(partyService.findById(i).get());
        }
        return parties;
    }

    @PostMapping(value = "/{id}/add-info/{userName}/{userEmail}")
    public User addInfo(@PathVariable String userName, @PathVariable String userEmail, @PathVariable(value = "id") User user) {
        user.setEmail(userEmail);
        user.setName(userName);
        userService.save(user);
        return user;
    }

     @PutMapping(value = "/{id}")
    public void update(@PathVariable Integer id, User user) {
        user.setId(id);
        userService.save(user);
        //     log..log(Level.INFO, "User was saved");
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping(value = "/add")
    public void addNew(@RequestBody User user) {
        if (!userService.existsByLogin(user.getLogin())) {
            userService.save(user);
        }

    }
}

