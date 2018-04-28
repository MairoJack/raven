package com.nevar.api.service.impl;

import com.nevar.api.entity.RoleEntity;
import com.nevar.api.repository.RoleRepository;
import com.nevar.api.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository repository;
    @Override
    public List<RoleEntity> getRoleValuesByUserId(Integer userId) {
        return repository.getRoleValuesByUserId(userId);
    }

    @Override
    public boolean isSuperAdmin(String username) {
        List<RoleEntity> list = repository.getRoleValuesByUsername(username);
        for(RoleEntity role : list){
            if(role.getValue().equals("admin")){
                return true;
            }
        }
        return false;
    }
}
