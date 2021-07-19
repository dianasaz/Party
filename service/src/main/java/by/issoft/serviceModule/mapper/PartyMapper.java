package by.issoft.serviceModule.mapper;

import by.issoft.jpa.entity.Party;
import by.issoft.dto.PartyDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = {ProductMapper.class, UserMapper.class})
public interface PartyMapper {
    Party fromDto(PartyDto dto);

    PartyDto toDto(Party party);

    List<PartyDto> toListDto(List<Party> parties);
}
