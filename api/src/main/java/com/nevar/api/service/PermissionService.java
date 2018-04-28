package com.nevar.api.service;


import com.nevar.api.entity.PermissionEntity;

import java.util.List;

public interface PermissionService {
    List<PermissionEntity> getPermissionsByRoleId(Integer roleId);
    List<PermissionEntity> getPermissionsByUsername(String username);
    List<PermissionEntity> findAll();
}
