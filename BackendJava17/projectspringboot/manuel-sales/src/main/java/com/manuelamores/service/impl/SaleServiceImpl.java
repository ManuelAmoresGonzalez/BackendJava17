package com.manuelamores.service.impl;

import com.manuelamores.model.Sale;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.repo.ISaleRepo;
import com.manuelamores.service.ISaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl extends CRUDImpl<Sale, Integer>  implements ISaleService {

    private final ISaleRepo repo;

    @Override
    protected IGenericRepo<Sale, Integer> getRepo() {
        return repo;
    }
}
