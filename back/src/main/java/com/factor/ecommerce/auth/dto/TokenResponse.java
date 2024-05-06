package com.factor.ecommerce.auth.dto;

public class TokenResponse {

    String token;
    String expiration; //TODO implementar
    Integer id; //TODO eliminar luego de reemplazar por manejo por token

    private TokenResponse(){}
    public TokenResponse( String token, String expiration, Integer id) {
        this.token = token;
        this.expiration = expiration;
        this.id = id;
    }
}
