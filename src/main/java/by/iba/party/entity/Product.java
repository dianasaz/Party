package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
@ToString
@Table (name = "product")
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "product_type_id")
    private ProductType type;
    
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Party> parties;

    @Column (name = "price")
    private Double price;

    @NotBlank
    @Column (name = "name")
    private String name;
}
