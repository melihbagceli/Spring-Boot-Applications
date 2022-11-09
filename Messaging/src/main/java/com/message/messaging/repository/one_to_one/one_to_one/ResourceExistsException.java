package com.message.messaging.repository.one_to_one.one_to_one;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Data
public class ResourceExistsException extends RuntimeException{
    private String resourceName;
    private String fieldName;
    private String fieldValue;
    public ResourceExistsException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s already exists with %s : '%s'",resourceName,fieldName,fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
