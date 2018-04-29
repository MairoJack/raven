package com.nevar.api.service.impl;


import com.nevar.api.entity.PermissionEntity;
import com.nevar.api.entity.RoleEntity;
import com.nevar.api.entity.UserEntity;
import com.nevar.api.repository.PermissionRepository;
import com.nevar.api.repository.RoleRepository;
import com.nevar.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("用户:【" + username + "】未找到");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        List<RoleEntity> roleValues = roleRepository.getRoleValuesByUserId(userEntity.getId());
        for (RoleEntity role : roleValues) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_"+role.getValue());
            grantedAuthorities.add(grantedAuthority);

            List<PermissionEntity> permissionList =  permissionRepository.getPermissionsByRoleId(role.getId());
            for (PermissionEntity permission : permissionList){

                GrantedAuthority authority = new SimpleGrantedAuthority(permission.getCode());
                grantedAuthorities.add(authority);
            }
        }
        return new User(userEntity.getUsername(),userEntity.getPassword(),true,true,true,false,grantedAuthorities);
    }
}
