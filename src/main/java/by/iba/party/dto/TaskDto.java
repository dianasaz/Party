package by.iba.party.dto;

import by.iba.party.entity.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Integer id;
    private UserDto user;
    private ProductDto product;
    private PartyDto party;
    private Double money;
    private TaskStatus status;
    private Integer quantity;
}
