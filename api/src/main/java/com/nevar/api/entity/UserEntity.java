package com.nevar.api.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * 用户
 */
@Data
@Entity
@Table(name = "raven_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(200) COMMENT '用户名'")
    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "密码不能为空")
    @Column(columnDefinition = "varchar(255) COMMENT '密码'")
    private String password;

    @Column(name = "create_time",columnDefinition = "int(11) default '0' comment '创建时间'")
    private long createTime;


}
