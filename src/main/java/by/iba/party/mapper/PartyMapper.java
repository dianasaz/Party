package by.iba.party.mapper;

import by.iba.party.dto.PartyDto;
import by.iba.party.entity.Party;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {ProductMapper.class, UserMapper.class})
public interface PartyMapper {

    PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);

    Party fromDto(PartyDto dto);

    PartyDto toDto(Party party);

    List<PartyDto> toListDto(List<Party> parties);
}
