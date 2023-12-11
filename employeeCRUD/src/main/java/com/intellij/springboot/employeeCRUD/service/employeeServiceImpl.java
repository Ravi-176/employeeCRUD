package com.intellij.springboot.employeeCRUD.service;

import com.intellij.springboot.employeeCRUD.Entity.Employee;
import com.intellij.springboot.employeeCRUD.dao.DAO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeServiceImpl implements employeeService{
        private DAO employeeDAO;
        @Autowired
        public employeeServiceImpl(DAO theDAO){
            employeeDAO = theDAO;
        }
    @Override
    public List<Employee> findAll() {

            return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
         employeeDAO.deleteById(theId);
    }
}
