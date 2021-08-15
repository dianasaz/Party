package by.issoft.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.DigestUtils;

import javax.persistence.*;

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


    public void setPassword(String password){
        this.password = DigestUtils.md5DigestAsHex(password.getBytes());
    }
}
