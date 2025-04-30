package com.daytona.cruddemo.service;

import com.daytona.cruddemo.dao.EmployeeDao;
import com.daytona.cruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeedao;

    @Override
    public List<Employee> findAll() {
        var emp= employeedao.findAll();
        return emp;
    }

    @Override
    public Employee findById(Long theId) {
        return employeedao.findById(theId);
    }

    @Override
    @Transactional
    // @CacheEvict(value = "employeeCache", allEntries = true)
    public Employee save(Employee theEmployee) {
        var emp = employeedao.save(theEmployee);
        return emp;
    }

    @Override
    @Transactional
    public void deleteById(Long theId) {
        employeedao.deleteById(theId);
    }
}
