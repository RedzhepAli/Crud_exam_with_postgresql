package com.example.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException{

    public EmployeeNotFoundException(long id){
        super("Employee id not found:" + id);
    }
}
