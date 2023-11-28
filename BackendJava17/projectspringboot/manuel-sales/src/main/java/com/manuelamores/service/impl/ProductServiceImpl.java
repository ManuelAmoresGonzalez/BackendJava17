package com.manuelamores.service.impl;

import com.manuelamores.model.Product;
import com.manuelamores.repo.IProductRepo;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl extends CRUDImpl<Product, Integer>  implements IProductService {

    private final IProductRepo repo;

    @Override
    protected IGenericRepo<Product, Integer> getRepo() {
        return repo;
    }
}
