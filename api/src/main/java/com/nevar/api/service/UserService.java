package com.nevar.api.service;


import com.nevar.api.entity.UserEntity;

import java.util.List;

public interface UserService {
    UserEntity findByUsername(String username);

    List<UserEntity> findALl();

    UserEntity save(UserEntity userEntity);

    UserEntity update(UserEntity userEntity);

    void delete(Integer id);
}
