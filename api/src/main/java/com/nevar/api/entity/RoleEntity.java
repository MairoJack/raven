package com.nevar.api.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "raven_role")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(200) comment '角色名'")
    private String name;

    @Column(columnDefinition = "varchar(200) comment '角色值'")
    private String value;

}
