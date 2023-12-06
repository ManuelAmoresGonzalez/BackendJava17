package com.manuelamores.service.impl;

import com.manuelamores.model.Provider;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.repo.IProviderRepo;
import com.manuelamores.service.IProviderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProviderServiceImpl extends CRUDImpl<Provider, Integer>  implements IProviderService {

    private final IProviderRepo repo;

    @Override
    protected IGenericRepo<Provider, Integer> getRepo() {
        return repo;
    }
}
