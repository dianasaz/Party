package by.iba.party.controller.userInfo;

import by.iba.party.entity.UserInfo;
import by.iba.party.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (value = "/user-info")
public class UserInfoController {
    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    //JsonIgnore JsonView
    @GetMapping(value = "/all")
    public List<UserInfo> allInfos() {
        return userInfoService.findAll();
    }

    @GetMapping(value = "/{id}")
    public UserInfo getById(@PathVariable Integer id) {
        return userInfoService.findById(id).orElse(new UserInfo());
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void update(@PathVariable Integer id, @RequestBody UserInfo userInfo) {
        userInfo.setId(id);
        userInfoService.save(userInfo);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable Integer id) {
        userInfoService.deleteById(id);
    }

    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.OK)
    public void addNew(@RequestBody UserInfo userInfo) {
        userInfoService.save(userInfo);
    }

}
