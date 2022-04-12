package com.example.demo.service;

import com.example.demo.exceptions.DepartmentNotFoundException;
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
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id){
        return   departmentRepository.findById(id).orElseThrow(() -> new DepartmentNotFoundException(id));
    }

    @Override
    public List<Department> findAll(){ return departmentRepository.findAll();}

}
