package com.manuelamores.service;

import com.manuelamores.model.Category;
import com.manuelamores.repo.CategoryRepoImpl;
import com.manuelamores.repo.ICategoryRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategorySevice{


    private final ICategoryRepo repo;


    @Override
    public Category save(Category category) throws Exception {
        return repo.save(category);
    }

    @Override
    public Category update(Integer id) throws Exception {
        return null;
    }

    @Override
    public List<Category> readAll() throws Exception {
        return null;
    }

    @Override
    public Category readById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void delete(Integer id) throws Exception {

    }
}
