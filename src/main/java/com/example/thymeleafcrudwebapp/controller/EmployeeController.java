package com.example.thymeleafcrudwebapp.controller;

import com.example.thymeleafcrudwebapp.model.Employee;
import com.example.thymeleafcrudwebapp.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    // display list of employees
    @GetMapping
    public List<Employee> viewHomePage(){
//        model.addAttribute("listEmployees",employeeService.getAllEmployees());
//        return "index";
        return  employeeService.getAllEmployees();
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    //  @RequestBody will turn JSON data to java object

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        return employeeService.deleteEmployee(id);
    }
    // PathVariable is used to denote the path written variable

//    @GetMapping("/add")
//    public String showNewEmployeeForm(Model model){
//        Employee employee = new Employee();
//        model.addAttribute("employee", employee);
//        return "addEmployee";
//    }
//
//    @PostMapping ("/save")
//    public String saveEmployee(@ModelAttribute("employee") Employee employee){
//        // Save Employee to DB
//        employeeService.saveEmployee(employee);
//        return "redirect:/";
//    }
}