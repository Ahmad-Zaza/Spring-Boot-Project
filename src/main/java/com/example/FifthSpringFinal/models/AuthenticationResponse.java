package com.example.FifthSpringFinal.models;

import java.io.Serializable;

public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String token;
    private String username;
    private String firstName;
    private String lastName;

    public AuthenticationResponse(String token, String username, String firstName, String lastName) {
        this.token = token;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getToken() {
        return token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}