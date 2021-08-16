package by.issoft.restApi.user;

import by.issoft.exception.NoEntityException;
import by.issoft.restModel.PartyResponse;
import by.issoft.restModel.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RequestMapping(value = "/users")
public interface UserController {
    @GetMapping(value = "/all")
    @ResponseStatus(HttpStatus.OK)
    List<UserResponse> allUsers();

    @GetMapping(value = "/{id}")
    UserResponse getById(@PathVariable Integer id) throws NoEntityException;

    @GetMapping(value = "/login/{login}/password/{password}")
    UserResponse getByLoginAndPassword(@PathVariable(value = "login") String login, @PathVariable(value = "password") String password);

    @GetMapping(value = "/{id}/parties")
    List<PartyResponse> getUsersParties(@PathVariable(value = "id") UserResponse user) throws NoEntityException;

    @PostMapping(value = "/{id}/add-info/{userName}/{userEmail}")
    UserResponse addInfo(@PathVariable String userName, @PathVariable String userEmail, @PathVariable(value = "id") UserResponse user);

    @PutMapping(value = "/{id}")
    void update(@PathVariable Integer id, UserResponse user);

    @DeleteMapping(value = "/{id}")
    void delete(@PathVariable Integer id);

    @PostMapping(value = "/add")
    void addNew(@RequestBody UserResponse user);
}

