package com.accord.repository;


import com.accord.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * User : Tanvir Ahmed
 * Date: 11/7/2024.
 */

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String roleName);
}
