package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Entity
@ToString
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "login")
    private String login;

    @NotBlank
    @Column(name = "password")
    private String password;

    public void setPassword(String password){
        this.password = DigestUtils.md5DigestAsHex(password.getBytes()); //todo fix password
    }
}
