package com.daytona.cruddemo.dao;

import com.daytona.cruddemo.entity.Employee;
import org.springframework.context.annotation.Lazy;

import java.util.List;

public interface EmployeeDao {
    List<Employee> findAll();

    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);

}
