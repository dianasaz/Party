package by.iba.party.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product_type")
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private String value;

    @Override
    public String toString() {
        return "ProductType{" +
                "id=" + id +
                ", value='" + value + '\'';
    }
}
