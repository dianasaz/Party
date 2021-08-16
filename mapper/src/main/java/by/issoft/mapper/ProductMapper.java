package by.issoft.mapper;

import by.issoft.entity.Product;
import by.issoft.dto.ProductDto;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, uses = ProductTypeMapper.class)
public interface ProductMapper {
    Product fromDto(ProductDto dto);

    ProductDto toDto(Product product);

    List<ProductDto> toListDto (List<Product> products);

    List<Product> fromListDto (List<ProductDto> productDtos);
}
