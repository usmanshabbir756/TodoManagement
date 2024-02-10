package com.usman.todo.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResponseNotFound extends RuntimeException{
    public ResponseNotFound(String message) {
        super(message);
    }
}
