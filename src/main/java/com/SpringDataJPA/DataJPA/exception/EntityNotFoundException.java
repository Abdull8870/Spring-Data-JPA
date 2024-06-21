package com.SpringDataJPA.DataJPA.exception;

public class EntityNotFoundException extends RuntimeException{

    public EntityNotFoundException(String resource,Class<?> entity){
        super("The "+entity.getSimpleName().toLowerCase() +" with resource "+resource
        +" doesn't exist in our record");
    }

}
