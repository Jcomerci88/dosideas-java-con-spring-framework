package com.dosideas.exception;

import org.springframework.web.bind.annotation.ResponseStatus;


public class NombreInvalidoException extends Exception {

    public NombreInvalidoException(String mensaje) {
        super(mensaje);
    }
}
