package com.daytona.cruddemo.service;

import com.daytona.cruddemo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeServiceImpl employeeServiceImpl;

    @Test
    void addEmployeeSuccessfully(){
        System.out.println("My first unit test");
        Employee employee=new Employee();
        employee.setId(1l);
        employee.setEmail("neha@mail.com");
        employee.setFirstName("neha");
        employee.setLastName("singh");
        Mockito.when(employeeService.save(employee)).thenReturn(employee);

       Employee addEmployee= employeeService.save(employee);
        Assertions.assertEquals(1,addEmployee.getId());
    }


}