package com.manuelamores.config;

import com.manuelamores.dto.CategoryDTO;
import com.manuelamores.dto.ProductDTO;
import com.manuelamores.model.Category;
import com.manuelamores.model.Product;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("categoryMapper")
    public ModelMapper categoryMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Category, CategoryDTO> typeMap1 = mapper.createTypeMap(Category.class, CategoryDTO.class);
        typeMap1.addMapping(Category::getName, (dest, value) -> dest.setNameOfCategory((String) value));

        /*TypeMap<CategoryDTO, Category> typeMap2 = mapper.createTypeMap(CategoryDTO.class, Category.class);
        typeMap2.addMapping(CategoryDTO::getNameOfCategory, (dest, value) -> dest.setName((String) value));*/

        return mapper;
    }

    @Bean("productMapper")
    public ModelMapper productMapper() {
        ModelMapper mapper = new ModelMapper();
        TypeMap<Product, ProductDTO> typeMap1 = mapper.createTypeMap(Product.class, ProductDTO.class);
        typeMap1.addMapping(category -> category.getCategory().getIdCategory(), (dest, value) -> dest.setIdCategorie((Integer) value));

        TypeMap<ProductDTO, Product> typeMap2 = mapper.createTypeMap(ProductDTO.class, Product.class);
        typeMap2.addMapping(ProductDTO::getIdCategorie, (dest, value) -> dest.getCategory().setIdCategory((Integer) value));

        return mapper;
    }

    @Bean("defaultMapper")
    public ModelMapper clientMapper() {
        return new ModelMapper();
    }
}
