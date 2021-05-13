package by.iba.party.mapper;

import by.iba.party.dto.UserDto;
import by.iba.party.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User fromDto(UserDto dto);

    UserDto toDto(User user);

    List<UserDto> toListDto (List<User> users);

    List<User> fromListDto (List<UserDto> userDtos);
}
