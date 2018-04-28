package com.nevar.api.repository;

import com.nevar.api.entity.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Integer> {
    @Query(value = "select rp.* from raven_permission rp,raven_role_permission rrp where rp.id = rrp.role_id and rrp.role_id=?",nativeQuery = true)
    List<PermissionEntity> getPermissionsByRoleId(Integer roleId);

    @Query(value = "SELECT p.* FROM raven_permission p,raven_role_permission rp,raven_role r " +
            "WHERE r.id=rp.role_id AND rp.permission_id=p.id AND  r.id IN " +
            "(SELECT r.id FROM raven_user u,raven_role r,raven_user_role ur " +
            "WHERE u.username = ? AND u.id=ur.user_id AND ur.role_id=r.id)",nativeQuery = true)
    List<PermissionEntity> getPermissionsByUsername(String username);
}
