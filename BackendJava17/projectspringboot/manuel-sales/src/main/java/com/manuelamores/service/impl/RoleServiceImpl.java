package com.manuelamores.service.impl;

import com.manuelamores.model.Role;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.repo.IRoleRepo;
import com.manuelamores.service.IRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends CRUDImpl<Role, Integer>  implements IRoleService {

    private final IRoleRepo repo;

    @Override
    protected IGenericRepo<Role, Integer> getRepo() {
        return repo;
    }
}
