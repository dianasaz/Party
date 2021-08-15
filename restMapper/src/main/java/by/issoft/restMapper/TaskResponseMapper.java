package by.issoft.restMapper;

import by.issoft.dto.TaskDto;
import by.issoft.restModel.TaskResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {UserResponseMapper.class, PartyResponseMapper.class, ProductResponseMapper.class})
public interface TaskResponseMapper {
    TaskResponse fromDto(TaskDto dto);

    TaskDto toDto(TaskResponse task);

    List<TaskDto> toListDto(List<TaskResponse> tasks);

    List<TaskResponse> fromListDto(List<TaskDto> taskDtos);

}
