package by.iba.party.config;

import by.iba.party.mapper.PartyMapper;
import by.iba.party.mapper.ProductMapper;
import by.iba.party.mapper.ProductTypeMapper;
import by.iba.party.mapper.TaskMapper;
import by.iba.party.mapper.UserMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
            }
        };
    }

//    @Bean
//    public PartyMapper partyMapper() {
//        return Mappers.getMapper( PartyMapper.class );
//    }
//
//    @Bean
//    public ProductMapper productMapper() {
//        return Mappers.getMapper( ProductMapper.class );
//    }
//
//    @Bean
//    public TaskMapper taskMapper() {
//        return Mappers.getMapper( TaskMapper.class );
//    }
//
//    @Bean
//    public ProductTypeMapper productTypeMapper() {
//        return Mappers.getMapper( ProductTypeMapper.class );
//    }
//
//    @Bean
//    public UserMapper userMapper() {
//        return Mappers.getMapper( UserMapper.class );
//    }
}
