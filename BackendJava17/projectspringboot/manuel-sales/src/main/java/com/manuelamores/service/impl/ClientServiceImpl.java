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

    @Override
    public Client save(Client client) throws Exception {
        return repo.save(client);
    }

    @Override
    public Client update(Client client, Integer id) throws Exception {
        client.setIdClient(id);
        return repo.save(client);
    }

    @Override
    public List<Client> readAll() throws Exception {
        return repo.findAll();
    }

    @Override
    public Client readById(Integer id) throws Exception {
        return repo.findById(id).orElse(new Client());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
