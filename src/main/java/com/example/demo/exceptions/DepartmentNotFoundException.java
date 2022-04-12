package com.example.demo.exceptions;

public class DepartmentNotFoundException extends RuntimeException{

    public DepartmentNotFoundException(long id){
        super("Department id not found" + id);
    }
}
