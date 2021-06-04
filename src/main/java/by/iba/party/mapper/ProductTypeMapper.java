package by.iba.party.mapper;

import by.iba.party.dto.ProductTypeDto;
import by.iba.party.entity.ProductType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductTypeMapper {
    ProductType fromDto(ProductTypeDto dto);

    ProductTypeDto toDto(ProductType productType);

    List<ProductTypeDto> toListDto (List<ProductType> productTypes);
}
