package br.com.josuemleite.model.exceptions;

public class APICredentialsNotFoundException extends RuntimeException {

    public APICredentialsNotFoundException(String message) {
        super(message);
    }
}
