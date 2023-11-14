package com.manuelamores.controller;

import com.manuelamores.dto.CategoryDTO;
import com.manuelamores.dto.CategoryRecord;
import com.manuelamores.model.Category;
import com.manuelamores.service.ICategorySevice;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
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
    private final ModelMapper mapper;
    
    @GetMapping
    public ResponseEntity<List<CategoryDTO>>  readAll() throws Exception {
        List<CategoryDTO> categoryDTO =  service.readAll()
                .stream()
                .map( value -> mapper.map(value, CategoryDTO.class))
                .toList();
        return new ResponseEntity<>(categoryDTO, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<CategoryDTO> readById(@PathVariable ("id") Integer id) throws Exception {
         Category category = service.readById(id);
         CategoryDTO dto = mapper.map(category, CategoryDTO.class);
         return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody Category category) throws Exception {
        Category createdCategory = service.save(category);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable ("id") Integer id) throws Exception {
        Category updatedCategory = service.update(category, id);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
