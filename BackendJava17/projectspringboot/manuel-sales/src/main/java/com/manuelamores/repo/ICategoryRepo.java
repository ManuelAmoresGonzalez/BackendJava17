package com.manuelamores.repo;

import com.manuelamores.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepo extends JpaRepository<Category, Integer> {

   // Category save(Category category);
}
