package br.com.packcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DoormanNotFoundException extends RuntimeException {
    public DoormanNotFoundException(String message) {
        super(message);
    }
}
