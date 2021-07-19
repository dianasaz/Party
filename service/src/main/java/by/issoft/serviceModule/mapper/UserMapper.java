package by.issoft.serviceModule.mapper;

import by.issoft.dto.UserDto;
import by.issoft.jpa.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    User fromDto(UserDto dto);

    UserDto toDto(User user);

    List<UserDto> toListDto (List<User> users);
}
