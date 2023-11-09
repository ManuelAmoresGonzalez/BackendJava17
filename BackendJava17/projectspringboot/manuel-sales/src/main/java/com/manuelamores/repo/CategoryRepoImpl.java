package com.manuelamores.repo;

import com.manuelamores.model.Category;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepoImpl implements ICategoryRepo{

    @Override
    public Category save(Category category) {
        System.out.println("Saving... "+category);
        return category;
    }
}
