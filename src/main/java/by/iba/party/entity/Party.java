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

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<User> users;

    @Column(name = "status")
    private PartyStatus status;

    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Product> products;

    @Column (name = "address")
    private String address;

    @Column (name = "date")
    private Date date;

    @Column (name = "number_of_people")
    private Integer numberOfPeople;
}
