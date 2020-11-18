package com.esi.msauth.repository;

import com.esi.msauth.Entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role getRoleByName(String name);
}
