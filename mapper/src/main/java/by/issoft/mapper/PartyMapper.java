package by.issoft.mapper;

import by.issoft.dto.PartyDto;
import by.issoft.entity.Party;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {ProductMapper.class, UserMapper.class})
public interface PartyMapper {
    Party fromDto(PartyDto dto);

    PartyDto toDto(Party party);

    List<PartyDto> toListDto(List<Party> parties);
}
