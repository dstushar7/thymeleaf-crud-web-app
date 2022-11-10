package com.example.thymeleafcrudwebapp.service;

import com.example.thymeleafcrudwebapp.model.Employee;
import com.example.thymeleafcrudwebapp.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;


//@SuppressWarnings("SpringJavaAutowiredMembersInspection") // Autowired Warning Removal
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository employeeRepository;


    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public ResponseEntity<HttpStatus> saveEmployee(Employee employee) {
        this.employeeRepository.save(employee);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Employee> getEmployeeById(long id) {
        Employee employee = employeeRepository.findById(id).orElseThrow(NullPointerException::new);
//        return employeeRepository.getById(id);
        return ResponseEntity.ok(employee);
    }


    @Override
    public ResponseEntity<HttpStatus> deleteEmployee(long id) {
        this.employeeRepository.deleteById(id);
        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(long id, Employee employeeDetails) {
        Employee updateEmployee = employeeRepository.findById(id).orElseThrow(NullPointerException::new);

        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmail(employeeDetails.getEmail());

        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }
}
