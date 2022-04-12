package com.example.demo.service;

import com.example.demo.model.Directorate;
import com.example.demo.model.Employee;

import javax.transaction.Transactional;
import java.util.List;

public interface DirectorateService {
    @Transactional
    Directorate save(Directorate directorate);

    @Transactional
    Employee addDirector(Employee director);

    void deleteDirectorate(Long id);

    Directorate findById(Long id);

    List<Directorate> findAll();
}
