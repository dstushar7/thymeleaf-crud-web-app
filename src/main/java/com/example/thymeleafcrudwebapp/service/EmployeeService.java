package com.example.thymeleafcrudwebapp.service;

import com.example.thymeleafcrudwebapp.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    void saveEmployee(Employee employee);
}