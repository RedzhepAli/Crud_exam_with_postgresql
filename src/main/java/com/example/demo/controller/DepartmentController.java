package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeRepository employeeRepository;



    @GetMapping("/find")
    public @ResponseBody
    List<Department>
    getDepartments() {
        List<Department> departments = departmentService.findAll();
        return departments;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDepartment(@PathVariable("id")Long id){
        departmentService.deleteDepartment(id);
    }
}
