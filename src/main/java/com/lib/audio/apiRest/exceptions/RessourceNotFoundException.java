package com.lib.audio.apiRest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.PersistenceException;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {

    private String ressourceName;
    private String fieldName;
    private String fieldValue;

    public RessourceNotFoundException(String ressourceName, String fieldName, String fieldValue){
        super(String.format("%s not found with %s : '%s' ",ressourceName,fieldName,fieldValue));
        this.fieldName = fieldName;
        this.ressourceName = ressourceName;
        this.fieldValue = fieldValue;
    }

    public String getRessourceName(){
        return ressourceName;
    }

    public String fieldName(){
        return fieldName;
    }

    public String fieldValue(){
        return fieldValue;
    }


}
