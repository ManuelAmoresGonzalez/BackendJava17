package com.manuelamores.repo;

import com.manuelamores.model.Category;

import java.util.List;

public interface ICategoryRepo extends IGenericRepo<Category, Integer> {

    List<Category> findByName(String name);
    List<Category> findByNameLike(String name);

    //%XYZ% -> findByNameContains
    //%XYZ -> findByNameStartsWith
    //XYZ% -> findByNameEndsWith
}
