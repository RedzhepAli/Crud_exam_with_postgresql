package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping ("/employee")
    public Employee getEmployee(@RequestParam(value = "age")int age,
                                @RequestParam(value = "firstname")String firstname,
                                @RequestParam(value = "lastname")String lastname,
                                @RequestParam(value = "pin")int pin,
                                @RequestParam(value = "position")String position){


        Employee employee = new Employee();

        employee.setAge(age);
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setPin(pin);
        employee.setPosition(position);
       return employee;
    }


    @PostMapping("/employee")
    public Employee postEmployee( Employee employee){
        System.out.println("Employee first name:" + employee.getFirstName());


        employeeService.save(employee);

        return employee;
    }



    @GetMapping("/getAll")
    public @ResponseBody
    List<Employee>
    getDirectorates() {
        List<Employee> employees = employeeService.findAll();
        return employees;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id")Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/find/{id}")
    public Employee findDirectorateById(@PathVariable("id")Long id){
        return employeeService.findById(id);
    }


}
