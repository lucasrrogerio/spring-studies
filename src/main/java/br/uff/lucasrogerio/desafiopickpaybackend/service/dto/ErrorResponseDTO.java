package br.uff.lucasrogerio.desafiopickpaybackend.service.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO {
    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public ErrorResponseDTO() {
        this.timestamp = LocalDateTime.now();
    }

    public ErrorResponseDTO statusCode(int statusCode) {
        this.status = statusCode;
        return this;
    }

    public ErrorResponseDTO error(String error) {
        this.error = error;
        return this;
    }

    public ErrorResponseDTO message(String message) {
        this.message = message;
        return this;
    }

    public ErrorResponseDTO path(String path) {
        this.path = path;
        return this;
    }

}
