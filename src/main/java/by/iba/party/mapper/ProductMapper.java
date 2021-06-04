package by.iba.party.mapper;

import by.iba.party.dto.ProductDto;
import by.iba.party.entity.Product;
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
