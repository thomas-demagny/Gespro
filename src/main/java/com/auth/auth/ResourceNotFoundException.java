package com.auth.auth;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    private Object fieldValue;
    private String fieldName;
    private String resourceName;

    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(String.format("%s not found with %s : '%s'", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

    public Object getFieldValue() {
        return fieldValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getResourceName() {
        return resourceName;
    }
}
    

