package by.iba.party.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@ToString
@Table (name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column (name = "name")
    private String name;

    @Column (name = "email")
    private String email;

    @JsonCreator
    User (Integer id){
        this.id = id;
    }

    public void setPassword(String password){
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
