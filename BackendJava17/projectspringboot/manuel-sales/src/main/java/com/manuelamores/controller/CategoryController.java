package com.manuelamores.controller;

import com.manuelamores.model.Category;
import com.manuelamores.service.CategoryServiceImpl;
import com.manuelamores.service.ICategorySevice;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController{

    private final ICategorySevice service;
    
    @GetMapping
    public Category saveCategory(){
        return service.validAndSave(new Category(1, "TV", "television", true));
    }
}
