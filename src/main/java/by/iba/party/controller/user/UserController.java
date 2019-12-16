package by.iba.party.controller.user;

import by.iba.party.entity.User;
import by.iba.party.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;

@RestController
@Log4j2
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
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

    @PostMapping(value = "/login")
    public User getByLoginAndPassword(@RequestBody User user) {
        User u = userService.findByLoginAndPassword(user.getLogin(), user.getPassword());
       // if (u.getLogin() != null ) System.out.println("yhy");
        return u;
    }


    //post создание сущностей
    //put обновлять вроде
    //REQUEST BODY для добавления новых (метод принимает @RequestBody Mentor mentor)
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

