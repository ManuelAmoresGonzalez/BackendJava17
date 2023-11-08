package com.manuelamores.repo;

import com.manuelamores.model.Category;


public class CategoryRepo {

    public Category save(Category category) {
        System.out.println("Saving... "+category);
        return category;
    }
}
