package com.manuelamores.service.impl;

import com.manuelamores.model.User;
import com.manuelamores.repo.IGenericRepo;
import com.manuelamores.repo.IUserRepo;
import com.manuelamores.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<User, Integer>  implements IUserService {

    private final IUserRepo repo;

    @Override
    protected IGenericRepo<User, Integer> getRepo() {
        return repo;
    }
}
