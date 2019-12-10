package by.iba.party.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table (name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "value")
    private String value;

//    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
//    private List<Product> products;

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", value='" + value + '\'';
    }
}
