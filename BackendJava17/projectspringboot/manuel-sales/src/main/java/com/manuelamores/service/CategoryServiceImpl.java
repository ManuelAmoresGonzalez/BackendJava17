package com.manuelamores.service;

import com.manuelamores.model.Category;
import com.manuelamores.repo.CategoryRepoImpl;
import com.manuelamores.repo.ICategoryRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategorySevice{


    private final ICategoryRepo repo;

    public Category validAndSave(Category category){
        if(category.getIdCategory() > 0){
            return repo.save(category);
        }else{
            return new Category();
        }
    }
}
