package by.issoft.restModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Integer id;
    private ProductTypeResponse type;
    private Double price;
    private String name;
    private String measure;
}
