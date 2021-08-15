package by.issoft.restModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {
    private Integer id;
    private UserResponse user;
    private ProductResponse product;
    private PartyResponse party;
    private Double money;
    private TaskStatusResponse status;
    private Integer quantity;
}
