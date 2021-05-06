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
    private UserDto userDto;
    private ProductDto productDto;
    private PartyDto partyDto;
    private Double money;
    private TaskStatus status;
    private Integer kol;
}
