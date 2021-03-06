package by.iba.party.dto;

import by.iba.party.entity.PartyStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyDto {
    private Integer id;
    private String name;
    @JsonIgnore
    private List<UserDto> users;
    private PartyStatus status;
    @JsonIgnore
    private List<ProductDto> products;
    @JsonIgnore
    private List<TaskDto> tasks;
    private String address;
    private Date date;
}
