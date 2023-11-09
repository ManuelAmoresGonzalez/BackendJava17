package com.manuelamores.service;

import com.manuelamores.model.Category;
import com.manuelamores.repo.CategoryRepoImpl;
import com.manuelamores.repo.ICategoryRepo;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImpl implements ICategorySevice{


    private final ICategoryRepo repo;


    public CategoryServiceImpl(CategoryRepoImpl repo) {
        this.repo = repo;
    }

    public Category validAndSave(Category category){
        if(category.getIdCategory() > 0){
            return repo.save(category);
        }else{
            return new Category();
        }
    }
}
