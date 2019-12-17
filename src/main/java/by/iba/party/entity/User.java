package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.util.DigestUtils;

import javax.persistence.*;
import java.util.List;

@Data
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

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Task> tasks;

    public void setPassword(String password){
        this.password = DigestUtils.md5DigestAsHex(password.getBytes()); //todo fix password
    }
}
