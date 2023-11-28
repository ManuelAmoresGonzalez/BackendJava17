package com.manuelamores.controller;

import com.manuelamores.dto.CategoryDTO;
import com.manuelamores.dto.CategoryRecord;
import com.manuelamores.model.Category;
import com.manuelamores.service.ICategorySevice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController{

    private final ICategorySevice service;
    @Qualifier("categoryMapper")
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<CategoryDTO>>  readAll() throws Exception {
        List<CategoryDTO> categoryDTO =  service.readAll()
                .stream()
                .map(this::convertToDTO)
                .toList();
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Category category = service.readById(id);
         return new ResponseEntity<>(convertToDTO(category), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> create(@RequestBody CategoryDTO dto) throws Exception {
        Category createdCategory = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdCategory), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO dto, @PathVariable ("id") Integer id) throws Exception {
        Category updatedCategory = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedCategory), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private CategoryDTO convertToDTO(Category category) {
        return mapper.map(category, CategoryDTO.class);
    }


    private Category convertToEntity(CategoryDTO dto) {
        return mapper.map(dto, Category.class);
    }
}
