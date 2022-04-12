package com.example.demo.exceptions;

public class DirectorateNotFoundException extends RuntimeException{

    public DirectorateNotFoundException(Long id){
        super("Directorate id not found:" + id);
    }
}
