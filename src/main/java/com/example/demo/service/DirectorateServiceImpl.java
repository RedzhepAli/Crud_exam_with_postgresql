package com.example.demo.service;

import com.example.demo.exceptions.DirectorateNotFoundException;
import com.example.demo.model.Department;
import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;
import com.example.demo.repository.DirectorateRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DirectorateServiceImpl implements DirectorateService {

    @Autowired
    private DirectorateRepository directorateRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public Directorate save(Directorate directorate){
        return directorateRepository.save(directorate);
    }

    @Override
    @Transactional
    public Employee addDirector(Employee director){

        Directorate directorate = new Directorate();

        director = employeeRepository.save(director);

        Department department = new Department();
        department.setName("Department A");
        department.setDescription("Department description");


        directorate.setName("Director");
        directorate.setDescription("Directorate description");
        directorate.setDirector(director);
        directorate.setDepartments(department);

        directorateRepository.save(directorate);


        return director;
    }


    @Override
    public void deleteDirectorate(Long id){
       directorateRepository.deleteById(id);
    }

    @Override
    public Directorate findById(Long id){
      return   directorateRepository.findById(id).orElseThrow(() -> new DirectorateNotFoundException(id));
    }

    @Override
    public List<Directorate> findAll(){ return directorateRepository.findAll();}


}
