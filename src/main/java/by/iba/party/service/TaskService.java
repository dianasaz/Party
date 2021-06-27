package by.iba.party.service;

import by.iba.party.dto.PartyDto;
import by.iba.party.dto.ProductDto;
import by.iba.party.dto.TaskDto;
import by.iba.party.dto.UserDto;

import java.util.List;

public interface TaskService extends Service<TaskDto> {
    List<TaskDto> findAllByUser(UserDto userInfoDto);

    TaskDto checkExistTask(PartyDto partyDto, ProductDto productDto);

    List<TaskDto> findAllByUserAndParty(UserDto userDto, PartyDto partyDto);

}
