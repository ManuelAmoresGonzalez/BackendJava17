package com.manuelamores.controller;

import com.manuelamores.model.Category;
import com.manuelamores.service.CategoryServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController implements ICategoryController{

    private CategoryServiceImpl service;

    public CategoryController(CategoryServiceImpl service) {
        this.service = service;
    }

    
    @GetMapping
    public Category saveCategory(){
        return service.validAndSave(new Category(1, "TV", "television", true));
    }
}
