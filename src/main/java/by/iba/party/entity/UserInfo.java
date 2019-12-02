package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table (name = "user_info")
public class UserInfo {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column (name = "name")
    private String name;

    @OneToMany(mappedBy = "userInfo", fetch = FetchType.LAZY)
    private List<Task> tasks;
}
