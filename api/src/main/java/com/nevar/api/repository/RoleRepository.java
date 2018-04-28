package com.nevar.api.repository;

import com.nevar.api.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    @Query(value = "select rr.* from raven_role rr,raven_user_role rur where rr.id = rur.role_id and rur.user_id=?",nativeQuery = true)
    List<RoleEntity> getRoleValuesByUserId(Integer roleId);

    @Query(value = "SELECT r.* FROM raven_user u,raven_role r,raven_user_role ur " +
            "WHERE u.username = ? AND u.id=ur.user_id AND ur.role_id=r.id",nativeQuery = true)
    List<RoleEntity> getRoleValuesByUsername(String username);
}
