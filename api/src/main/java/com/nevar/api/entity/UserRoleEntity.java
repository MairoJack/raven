package com.nevar.api.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 用户角色关系
 */
@Data
@Entity
@Table(name = "raven_user_role")
public class UserRoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id",columnDefinition = "int(11) comment '用户ID'")
    private int userId;

    @Column(name = "role_id",columnDefinition = "int(11) comment '角色ID'")
    private int roleId;

    @Column(name = "create_time",columnDefinition = "int(11) default '0' comment '创建时间'")
    private long createTime;
}
