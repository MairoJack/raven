package com.nevar.api.service.impl;

import com.nevar.api.entity.UserEntity;
import com.nevar.api.exception.BusinessException;
import com.nevar.api.exception.ErrorCode;
import com.nevar.api.repository.UserRepository;
import com.nevar.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserEntity findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<UserEntity> findALl() {
        return repository.findAll();
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        if (repository.findByUsername(userEntity.getUsername()) != null) {
            throw new BusinessException(ErrorCode.USERNAME_REPATE);
        }
        return repository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        if (repository.findByUsername(userEntity.getUsername()) != null) {
            throw new BusinessException(ErrorCode.USERNAME_REPATE);
        }
        return repository.saveAndFlush(userEntity);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
