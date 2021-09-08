package by.iba.party.controller.user;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.UserDto;
import by.iba.party.exception.NoEntityException;
import by.iba.party.security.JwtTokenProvider;
import by.iba.party.service.PartyService;
import by.iba.party.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final PartyService partyService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserController(AuthenticationManager authenticationManager, UserService userService, PartyService partyService, JwtTokenProvider jwtTokenProvider) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.partyService = partyService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @GetMapping(value = "/all")
    @PreAuthorize("hasAuthority('read')")
    public List<UserDto> allUsers() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('read')")
    public UserDto getById(@PathVariable Integer id) throws NoEntityException {
        return userService.findById(id);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> getByLoginAndPassword(@RequestBody UserDto userDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userDto.getLogin(), userDto.getPassword()));
            UserDto user = userService.findByLogin(userDto.getLogin());
            String token = jwtTokenProvider.createToken(userDto.getLogin(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid login/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping(value = "/{id}/parties")
    @PreAuthorize("hasAuthority('read')")
    public List<PartyDto> getUsersParties(@PathVariable(value = "id") UserDto user) throws NoEntityException {
        List<PartyDto> parties = new ArrayList<>();
        for (Integer i : userService.getUsersParties(user)) {
            parties.add(partyService.findById(i));
        }

        return parties;
    }

    @PostMapping(value = "/{id}/add-info/{userName}/{userEmail}")
    @PreAuthorize("hasAuthority('write')")
    public UserDto addInfo(@PathVariable String userName, @PathVariable String userEmail, @PathVariable(value = "id") UserDto user) {
        user.setEmail(userEmail);
        user.setName(userName);
        return userService.save(user);
    }

    @PutMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void update(@PathVariable Integer id, UserDto user) {
        user.setId(id);
        userService.save(user);
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasAuthority('write')")
    public void delete(@PathVariable Integer id) {
        userService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @PreAuthorize("hasAuthority('write')")
    public void addNew(@RequestBody UserDto user) {
        if (!userService.existsByLogin(user.getLogin())) {
            userService.save(user);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }
}

