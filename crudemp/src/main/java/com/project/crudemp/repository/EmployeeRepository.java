package com.project.crudemp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.crudemp.model.Emplyee;

@Repository
public interface EmployeeRepository extends JpaRepository<Emplyee,Long>{
    
}
