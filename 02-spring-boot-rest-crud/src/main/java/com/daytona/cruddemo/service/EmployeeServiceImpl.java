package com.daytona.cruddemo.service;

import com.daytona.cruddemo.dao.EmployeeDao;
import com.daytona.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    //define fields for entity manager
    private EmployeeDao employeedao;

    //constructor injection
    @Autowired
    public EmployeeServiceImpl(EmployeeDao theEmployeeDao){
        employeedao=theEmployeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeedao.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeedao.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee theEmployee) {
        return employeedao.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeedao.deleteById(theId);

    }
}
