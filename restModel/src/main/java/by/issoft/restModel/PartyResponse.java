package by.issoft.restModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PartyResponse {
    private Integer id;
    private String name;
    @JsonIgnore
    private List<UserResponse> users;
    private PartyStatusResponse status;
    @JsonIgnore
    private List<ProductResponse> products;
    @JsonIgnore
    private List<TaskResponse> tasks;
    private String address;
    private Date date;
}
