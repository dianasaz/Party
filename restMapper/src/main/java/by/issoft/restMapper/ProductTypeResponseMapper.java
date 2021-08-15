package by.issoft.restMapper;

import by.issoft.dto.ProductTypeDto;
import by.issoft.restModel.ProductTypeResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ProductTypeResponseMapper {
    ProductTypeResponse fromDto(ProductTypeDto dto);

    ProductTypeDto toDto(ProductTypeResponse productType);

    List<ProductTypeDto> toListDto(List<ProductTypeResponse> productTypes);

    List<ProductTypeResponse> fromListDto(List<ProductTypeDto> productTypeDtos);

}
