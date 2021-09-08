package by.iba.party.dto;

import by.iba.party.entity.Role;
import by.iba.party.entity.Status;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.DigestUtils;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;
    private String login;
    @JsonIgnore
    private String password;
    private String name;
    private String email;
    private Role role;
    private Status status;

    @JsonCreator
    UserDto (Integer id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
