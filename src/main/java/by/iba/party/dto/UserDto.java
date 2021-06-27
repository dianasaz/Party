package by.iba.party.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.DigestUtils;

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

    @JsonCreator
    UserDto (Integer id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
