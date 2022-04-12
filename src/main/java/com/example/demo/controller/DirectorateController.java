package com.example.demo.controller;

import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;
import com.example.demo.service.DirectorateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/directorate")
public class DirectorateController {

    @Autowired
    private DirectorateService directorateService;

    @GetMapping ("/director")
    public Employee getDirector(@RequestParam(value = "age")int age,
                                @RequestParam(value = "firstname")String firstname,
                                @RequestParam(value = "lastname")String lastname,
                                @RequestParam(value = "pin")int pin){


        Employee employee = new Employee();

        employee.setAge(age);
        employee.setFirstName(firstname);
        employee.setLastName(lastname);
        employee.setPin(pin);
        employee.setPosition("director");

        return employee;
    }

    @PostMapping("/director")
    public Employee postDirector( Employee employee){
        System.out.println("Employee first name:" + employee.getFirstName());


        directorateService.addDirector(employee);

        return employee;
    }


    @GetMapping("/getAll")
    public @ResponseBody
    List<Directorate>
    getDirectorates() {
        List<Directorate> directorates = directorateService.findAll();
        return directorates;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteDirectorate(@PathVariable("id")Long id){
        directorateService.deleteDirectorate(id);
    }

    @GetMapping("/find/{id}")
    public Directorate findDirectorateById(@PathVariable("id")Long id){
        return directorateService.findById(id);
    }




}
