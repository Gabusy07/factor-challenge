package com.factor.ecommerce.auth.controller.request.response;

public class UserResponse {

    String token;
    String message;
    Integer id; //TODO eliminar luego de reemplazar por manejo por token

    private UserResponse(){}

    public UserResponse(String token, String message, Integer id) {
        this.token = token;
        this.message = message;
        this.id = id;
    }


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserResponse{" +
                "token='" + token + '\'' +
                ", message='" + message + '\'' +
                ", id=" + id +
                '}';
    }
}
