package com.manuelamores.service.impl;

import com.manuelamores.model.Category;
import com.manuelamores.repo.ICategoryRepo;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category,Integer> implements ICategoryService {

    private final ICategoryRepo repo;

    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }


    @Override
    public List<Category> findByName(String name) {
        return repo.findByName(name);
    }

    @Override
    public List<Category> findByNameLike(String name) {
        return repo.findByNameLike("%" + name + "%");
    }
}
