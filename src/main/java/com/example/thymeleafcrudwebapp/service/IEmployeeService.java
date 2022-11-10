package com.example.thymeleafcrudwebapp.service;

import com.example.thymeleafcrudwebapp.model.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAllEmployees();
    ResponseEntity<HttpStatus> saveEmployee(Employee employee);

//    Employee getEmployeeById(long id);
    ResponseEntity<Employee> getEmployeeById(long id);
    ResponseEntity<Employee> updateEmployee(long id, Employee employeeDetails);

//    void deleteEmployee(long id);
    ResponseEntity<HttpStatus> deleteEmployee(long id);
}