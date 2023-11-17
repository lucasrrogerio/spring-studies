package br.uff.lucasrogerio.desafiopickpaybackend.service.exception;

import lombok.Getter;

@Getter
public abstract class CustomException extends RuntimeException {

    private String message;
    private Throwable cause;

    public CustomException(String message) {
        this.message = message;
    }

    public CustomException(String message, Throwable cause) {
        this.message = message;
        this.cause = cause;
    }

}
