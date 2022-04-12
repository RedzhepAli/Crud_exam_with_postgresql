package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @JsonBackReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "headofdepartment_id", referencedColumnName = "id")
    private Employee headOfDepartment;

    @JsonBackReference
    @ManyToOne
    private Employee employee;

    @JsonManagedReference
    @OneToMany(mappedBy = "departments", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Directorate> directorateList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public List<Directorate> getDirectorateList() {
        return directorateList;
    }

    public void setDirectorateList(List<Directorate> directorateList) {
        this.directorateList = directorateList;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Employee getHeadOfDepartment() {
        return headOfDepartment;
    }

    public void setHeadOfDepartment(Employee headOfDepartment) {
        this.headOfDepartment = headOfDepartment;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
