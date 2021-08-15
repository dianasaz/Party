package by.issoft.restMapper;

import by.issoft.dto.PartyDto;
import by.issoft.restModel.PartyResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {ProductResponseMapper.class, UserResponseMapper.class})
public interface PartyResponseMapper {
    PartyResponse fromDto(PartyDto dto);

    PartyDto toDto(PartyResponse party);

    List<PartyDto> toListDto(List<PartyResponse> parties);

    List<PartyResponse> fromListDto(List<PartyDto> parties);
}
