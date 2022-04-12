package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeService {


    @Transactional
    Employee save(Employee employee);


    List<Employee> findAll();

    Employee findById(Long id);

    void deleteEmployee(Long id);


}
