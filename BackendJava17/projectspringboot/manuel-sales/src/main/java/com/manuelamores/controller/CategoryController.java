package com.manuelamores.controller;

import com.manuelamores.model.Category;
import com.manuelamores.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService service;

    @GetMapping
    public Category saveCategory(){
        service = new CategoryService();
        return service.validAndSave(new Category(1, "TV", "television", true));
    }



}
