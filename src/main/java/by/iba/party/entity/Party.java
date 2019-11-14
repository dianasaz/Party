package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table (name = "party")
public class Party {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<User> users;

    @Column(name = "status")
    private PartyStatus status;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Product> products;

    //todo list products. Question : what is the relation between them

}
