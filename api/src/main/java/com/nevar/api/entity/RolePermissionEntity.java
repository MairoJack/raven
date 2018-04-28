package com.nevar.api.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 角色权限关系
 */
@Data
@Entity
@Table(name = "raven_role_permission")
public class RolePermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "permission_id",columnDefinition = "int(11) comment '权限ID'")
    private int permissionId;

    @Column(name = "role_id",columnDefinition = "int(11) comment '角色ID'")
    private int roleId;

    @Column(name = "create_time",columnDefinition = "int(11) default '0' comment '创建时间'")
    private long createTime;
}
