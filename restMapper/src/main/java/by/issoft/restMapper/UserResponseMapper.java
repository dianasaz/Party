package by.issoft.restMapper;

import by.issoft.dto.UserDto;
import by.issoft.restModel.UserResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface UserResponseMapper {
    UserResponse fromDto(UserDto dto);

    UserDto toDto(UserResponse user);

    List<UserDto> toListDto(List<UserResponse> users);

    List<UserResponse> fromListDto(List<UserDto> userDtos);

}
