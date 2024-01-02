package com.manuelamores.controller;

import com.manuelamores.dto.CategoryDTO;
import com.manuelamores.model.Category;
import com.manuelamores.service.ICategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController{

    private final ICategoryService service;
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
    public ResponseEntity<CategoryDTO> create(@Valid @RequestBody CategoryDTO dto) throws Exception {
        Category createdCategory = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDTO(createdCategory), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<CategoryDTO> update(@Valid @RequestBody CategoryDTO dto, @PathVariable ("id") Integer id) throws Exception {
        //dto.setIdCategory(id); //Use java reflection in the save method
        Category updatedCategory = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(convertToDTO(updatedCategory), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable ("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Queries
    @GetMapping("/find/name/{name}")
    public ResponseEntity<List<CategoryDTO>> findByName(@PathVariable("name") String name){
        List<CategoryDTO> list = service.findByName(name).stream()
                .map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find/name/like/{name}")
    public ResponseEntity<List<CategoryDTO>> findByNameLike(@PathVariable("name") String name){
        List<CategoryDTO> list = service.findByNameLike(name).stream()
                .map(this::convertToDTO).toList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    private CategoryDTO convertToDTO(Category category) {
        return mapper.map(category, CategoryDTO.class);
    }


    private Category convertToEntity(CategoryDTO dto) {
        return mapper.map(dto, Category.class);
    }
}
