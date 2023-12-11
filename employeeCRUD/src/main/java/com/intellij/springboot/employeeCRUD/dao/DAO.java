package com.intellij.springboot.employeeCRUD.dao;

import com.intellij.springboot.employeeCRUD.Entity.Employee;

import java.util.List;

public interface DAO {

    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
