package by.iba.party.mapper;

import by.iba.party.dto.ProductTypeDto;
import by.iba.party.entity.ProductType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProductTypeMapper {
    ProductTypeMapper INSTANCE = Mappers.getMapper(ProductTypeMapper.class);

    ProductType fromDto(ProductTypeDto dto);

    ProductTypeDto toDto(ProductType productType);

    List<ProductTypeDto> toListDto (List<ProductType> productTypes);
}
