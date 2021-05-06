package by.iba.party.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Integer id;
    private ProductTypeDto productTypeDto;
    private Double price;
    private String name;
    private String measure;
}
