package by.issoft.restMapper;

import by.issoft.dto.ProductDto;
import by.issoft.restModel.ProductResponse;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = ProductTypeResponseMapper.class)
public interface ProductResponseMapper {
    ProductResponse fromDto(ProductDto dto);

    ProductDto toDto(ProductResponse product);

    List<ProductDto> toListDto(List<ProductResponse> products);

    List<ProductResponse> fromListDto(List<ProductDto> productDtos);
}
