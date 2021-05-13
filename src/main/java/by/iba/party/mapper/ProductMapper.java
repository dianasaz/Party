package by.iba.party.mapper;

import by.iba.party.dto.ProductDto;
import by.iba.party.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = ProductTypeMapper.class)
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product fromDto(ProductDto dto);

    ProductDto toDto(Product product);

    List<ProductDto> toListDto (List<Product> products);

    List<Product> fromListDto (List<ProductDto> productDtos);
}
