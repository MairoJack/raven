package com.nevar.api.service;

import com.nevar.api.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getRoleValuesByUserId(Integer userId);

    /**
     * 判断是否是超级管理员
     * @param username
     * @return
     */
    boolean isSuperAdmin(String username);
}
