package com.manuelamores.service;

import com.manuelamores.model.Category;

import java.util.List;

public interface ICategorySevice {

    Category save(Category category) throws Exception;
    Category update(Integer id) throws Exception;
    List<Category> readAll() throws Exception;
    Category readById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;

}
