package com.manuelamores.repo;

import com.manuelamores.controller.CategoryController;
import com.manuelamores.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepo {

    public Category save(Category category) {
        System.out.println("Saving... "+category);
        return category;
    }
}
