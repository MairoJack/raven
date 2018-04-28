package com.nevar.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.nevar.api.entity.PermissionEntity;
import com.nevar.api.entity.RoleEntity;
import com.nevar.api.entity.UserEntity;
import com.nevar.api.service.PermissionService;
import com.nevar.api.service.RoleService;
import com.nevar.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Properties;

@RestController
public class IndexController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;

    @ResponseBody
    @RequestMapping(value = "/menu")
    public List<PermissionEntity> menu(Principal user) {
        List<PermissionEntity> list;
        if (roleService.isSuperAdmin(user.getName())) {
            list = permissionService.findAll();
        } else {
            list = permissionService.getPermissionsByUsername(user.getName());
        }
        return list;
    }

    @ResponseBody
    @RequestMapping(value = "/index")
    public JSONObject index(Principal user) throws UnknownHostException {
        JSONObject json = new JSONObject();
        UserEntity userEntity = userService.findByUsername(user.getName());
        json.put("user", userEntity);

        Properties props = System.getProperties();
        JSONObject jsonSystemInfo = new JSONObject();
        jsonSystemInfo.put("os_name",props.getProperty("os.name"));
        InetAddress localHost = InetAddress.getLocalHost();
        jsonSystemInfo.put("ip",localHost.getHostAddress());

        json.put("system_info", jsonSystemInfo);
        return json;
    }
}
