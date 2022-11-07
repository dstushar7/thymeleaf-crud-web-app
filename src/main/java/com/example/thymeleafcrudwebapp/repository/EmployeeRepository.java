package com.example.thymeleafcrudwebapp.repository;

import com.example.thymeleafcrudwebapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    
}