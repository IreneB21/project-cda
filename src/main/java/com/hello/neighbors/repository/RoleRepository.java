package com.hello.neighbors.repository;

import com.hello.neighbors.entity.Role;
import com.hello.neighbors.entity.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(RoleName roleName);
}
