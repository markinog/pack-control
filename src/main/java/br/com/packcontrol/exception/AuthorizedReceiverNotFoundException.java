package br.com.packcontrol.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AuthorizedReceiverNotFoundException extends RuntimeException {
    public AuthorizedReceiverNotFoundException(String message) {
        super(message);
    }
}
