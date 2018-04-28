package com.nevar.api.service.impl;

import com.nevar.api.entity.PermissionEntity;
import com.nevar.api.repository.PermissionRepository;
import com.nevar.api.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionRepository repository;

    @Override
    public List<PermissionEntity> getPermissionsByRoleId(Integer roleId) {
        return repository.getPermissionsByRoleId(roleId);
    }

    @Override
    public List<PermissionEntity> getPermissionsByUsername(String username) {
        return repository.getPermissionsByUsername(username);
    }

    @Override
    public List<PermissionEntity> findAll() {
        return repository.findAll();
    }
}
