package com.intellij.springboot.employeeCRUD.rest;

import com.intellij.springboot.employeeCRUD.Entity.Employee;
import com.intellij.springboot.employeeCRUD.dao.DAO;
import com.intellij.springboot.employeeCRUD.service.employeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //inject the DAO using constructor injection
    private employeeService empService;

    public EmployeeRestController(employeeService theService){
                empService = theService;
    }
    //expose api endpoint and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return empService.findAll();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId){
        Employee theEmployee = empService.findById(employeeId);
        if(theEmployee == null){
            throw new RuntimeException("Employee not found->"+employeeId);
        }
        return theEmployee;
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee){
        //in case the user is passing id,we need to set it to 0
        theEmployee.setId(0);
        Employee dbEmployee = empService.save(theEmployee);
        return dbEmployee;
    }
    @PutMapping("/employees")
    public Employee updateEmp(@RequestBody Employee theEmployee){
        Employee dbEmp = empService.save(theEmployee);
        return dbEmp;
    }
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmp(@PathVariable int employeeId){
        Employee tempEmp = empService.findById(employeeId);
        if(tempEmp == null){
            throw new RuntimeException("Employee id not found -> "+employeeId);
        }
        empService.deleteById(employeeId);
        return "Employee deleted having id: "+employeeId;
    }
}