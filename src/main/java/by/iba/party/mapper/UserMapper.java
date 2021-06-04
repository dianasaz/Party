package by.iba.party.mapper;

import by.iba.party.dto.UserDto;
import by.iba.party.entity.User;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserMapper {
    User fromDto(UserDto dto);

    UserDto toDto(User user);

    List<UserDto> toListDto (List<User> users);
}
