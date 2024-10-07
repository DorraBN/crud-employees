package com.project.crudemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.crudemp.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    
}
