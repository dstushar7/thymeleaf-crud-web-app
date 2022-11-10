package com.example.thymeleafcrudwebapp.repository;

import com.example.thymeleafcrudwebapp.model.Employee;

public abstract class EmployeeRepositoryImpl implements IEmployeeRepository{
    @Override
    public Employee findByFirstName(String name) {
        return null;
    }
}