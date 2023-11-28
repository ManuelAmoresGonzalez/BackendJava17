package com.manuelamores.service.impl;

import com.manuelamores.model.Client;
import com.manuelamores.repo.IClientRepo;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends CRUDImpl<Client, Integer>  implements IClientService {

    private final IClientRepo repo;

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }
}
