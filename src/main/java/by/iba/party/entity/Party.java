package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@ToString
@Entity
@Table
public class Party {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "party_users",
            joinColumns = {@JoinColumn(name = "party_id")}, inverseJoinColumns = {@JoinColumn(name = "users_id")})
    private List<User> users;

    @Column(name = "status")
    @Enumerated(EnumType.ORDINAL)
    private PartyStatus status;

    @OneToMany
   private List<Product> products;

    @Column (name = "address")
    private String address;

    @Column (name = "date")
    private Date date;

}
