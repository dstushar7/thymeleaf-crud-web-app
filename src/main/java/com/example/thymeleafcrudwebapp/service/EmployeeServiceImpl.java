package com.example.thymeleafcrudwebapp.service;

import com.example.thymeleafcrudwebapp.model.Employee;
import com.example.thymeleafcrudwebapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


//@SuppressWarnings("SpringJavaAutowiredMembersInspection") // Autowired Warning Removal
@Service

public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
    }
}
