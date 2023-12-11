package com.intellij.springboot.employeeCRUD.service;

import com.intellij.springboot.employeeCRUD.Entity.Employee;

import java.util.List;

public interface employeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
