package com.example.demo.service;

import com.example.demo.model.Department;
import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface DepartmentService {

    void deleteDepartment(Long id);

    Department findById(Long id);

    List<Department> findAll();
}
