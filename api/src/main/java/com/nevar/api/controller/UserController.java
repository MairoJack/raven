package com.nevar.api.controller;

import com.nevar.api.entity.UserEntity;
import com.nevar.api.exception.BusinessException;
import com.nevar.api.exception.ErrorCode;
import com.nevar.api.model.Result;
import com.nevar.api.service.PermissionService;
import com.nevar.api.service.UserService;
import com.nevar.api.utils.DateUtil;
import com.nevar.api.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @ResponseBody
    @GetMapping
    public List<UserEntity> user(){
        return userService.findALl();
    }

    @PostMapping
    public Result save(@Validated UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setCreateTime(DateUtil.currentTimeMillis());
        userService.save(userEntity);
        return ResultUtil.success("保存成功");
    }

    @PutMapping
    public Result update(@Validated UserEntity userEntity){
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userService.update(userEntity);
        return ResultUtil.success("更新成功");
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") int id){
        userService.delete(id);
        return ResultUtil.success("删除成功");
    }
}
