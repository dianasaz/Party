package by.issoft.serviceApi;

import by.issoft.dto.PartyDto;
import by.issoft.dto.ProductDto;
import by.issoft.dto.TaskDto;
import by.issoft.dto.UserDto;

import java.util.List;

public interface TaskService extends Service<TaskDto> {
    List<TaskDto> findAllByUser(UserDto userInfoDto);

    TaskDto checkExistTask(PartyDto partyDto, ProductDto productDto);

    List<TaskDto> findAllByUserAndParty(UserDto userDto, PartyDto partyDto);

}
