package by.issoft.serviceModule.mapper;

import by.issoft.dto.ProductTypeDto;
import by.issoft.jpa.entity.ProductType;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductTypeMapper {
    ProductType fromDto(ProductTypeDto dto);

    ProductTypeDto toDto(ProductType productType);

    List<ProductTypeDto> toListDto (List<ProductType> productTypes);
}
