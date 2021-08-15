package by.issoft.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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

    @OneToMany(mappedBy = "party")
    private List<Task> tasks;

    @Column (name = "address")
    private String address;

    @Column (name = "date")
    private Date date;

}
