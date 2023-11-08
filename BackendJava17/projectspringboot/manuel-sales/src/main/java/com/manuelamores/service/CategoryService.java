package com.manuelamores.service;

import com.manuelamores.model.Category;
import com.manuelamores.repo.CategoryRepo;


public class CategoryService {

    private CategoryRepo repo;


    public Category validAndSave(Category category){
        if(category.getIdCategory() > 0){
            repo = new CategoryRepo();
            return repo.save(category);
        }else{
            return new Category();
        }
    }
}
