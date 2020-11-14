package com.air.myblog.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author air
 * @create 2020-10-25-21:19
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException(){}

    public NotFoundException(String message){
        super(message);
    }

    public NotFoundException(String message,Throwable cause){
        super(message, cause);
    }
}
