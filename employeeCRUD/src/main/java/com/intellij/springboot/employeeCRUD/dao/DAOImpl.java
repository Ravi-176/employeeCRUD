package com.intellij.springboot.employeeCRUD.dao;

import com.intellij.springboot.employeeCRUD.Entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOImpl implements DAO{
    //define field entity manager
    private EntityManager entityManager;
    //set up Constructor Injection
    @Autowired
    public DAOImpl(EntityManager theEM){
        entityManager = theEM;
    }

    @Override
    public List<Employee> findAll() {
        //create a query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        //execute the query and get result list
        List<Employee> result = theQuery.getResultList();
        //return the list
        return result;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int theId) {
         Employee theEmployee = entityManager.find(Employee.class,theId);
         entityManager.remove(theEmployee);
    }
}
