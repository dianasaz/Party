package by.issoft.mapper;

import by.issoft.dto.TaskDto;
import by.issoft.entity.Task;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {UserMapper.class, PartyMapper.class, ProductMapper.class})
public interface TaskMapper {
    Task fromDto(TaskDto dto);

    TaskDto toDto(Task task);

    List<TaskDto> toListDto (List<Task> tasks);
}
