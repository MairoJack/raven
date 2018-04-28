package com.nevar.api.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 权限
 */
@Data
@Entity
@Table(name = "raven_permission")
public class PermissionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(200) comment '权限名'")
    private String name;

    @Column(columnDefinition = "varchar(200) comment '权限编号'")
    private String code;

    @Column(columnDefinition = "varchar(200) comment '路径'")
    private String url;
}
