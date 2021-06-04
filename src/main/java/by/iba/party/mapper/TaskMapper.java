package by.iba.party.mapper;

import by.iba.party.dto.TaskDto;
import by.iba.party.entity.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {UserMapper.class, PartyMapper.class, ProductMapper.class})
public interface TaskMapper {
    Task fromDto(TaskDto dto);

    TaskDto toDto(Task task);

    List<TaskDto> toListDto (List<Task> tasks);
}
