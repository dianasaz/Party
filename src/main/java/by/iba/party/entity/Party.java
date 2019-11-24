package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
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

    @ManyToMany(cascade = {CascadeType.MERGE,  CascadeType.PERSIST})
    private List<User> users;

    @NotBlank
    @Column(name = "status")
    private PartyStatus status;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REMOVE})
    private List<Product> products;

    @NotBlank
    @Column (name = "address")
    private String address;

    @NotBlank
    @Column (name = "date")
    private Date date;

    @NotBlank
    @Column (name = "number_of_people")
    private Integer numberOfPeople;
}
