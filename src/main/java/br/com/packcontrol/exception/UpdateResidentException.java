package br.com.packcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UpdateResidentException extends RuntimeException {
    public UpdateResidentException(String message) {
        super(message);
    }
}
