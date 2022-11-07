package com.example.thymeleafcrudwebapp.controller;

import com.example.thymeleafcrudwebapp.model.Employee;
import com.example.thymeleafcrudwebapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller // Indicates a controller component
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/employee/add")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "addEmployee";
    }

    @PostMapping ("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        // Save Employee to DB
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }
}
