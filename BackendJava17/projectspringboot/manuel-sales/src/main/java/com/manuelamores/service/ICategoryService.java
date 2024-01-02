package com.manuelamores.service;

import com.manuelamores.model.Category;

import java.util.List;

public interface ICategoryService extends ICRUD<Category, Integer>{

    List<Category> findByName(String name);

    List<Category> findByNameLike(String name);
}
