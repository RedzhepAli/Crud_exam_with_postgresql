package com.example.demo.service;

import com.example.demo.exceptions.DirectorateNotFoundException;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.DirectorateRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    @Transactional
    public Employee save(Employee employee){

        employee = employeeRepository.save(employee);

        return employee;
    }



    @Override
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id){
        return   employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @Override
    public List<Employee> findAll(){ return employeeRepository.findAll();}


}
