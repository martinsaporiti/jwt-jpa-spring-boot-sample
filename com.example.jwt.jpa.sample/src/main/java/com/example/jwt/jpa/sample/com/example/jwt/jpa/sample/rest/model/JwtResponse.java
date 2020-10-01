package com.example.jwt.jpa.sample.com.example.jwt.jpa.sample.rest.model;

/**
 * @author: martinsaporiti
 * @date: 29/09/2020
 */
public class JwtResponse {

    private final String username;
    private final String jwttoken;

    public JwtResponse(String username, String jwttoken) {
        this.username = username;
        this.jwttoken = jwttoken;
    }

    public String getUsername() {
        return username;
    }

    public String getJwttoken() {
        return jwttoken;
    }


}
