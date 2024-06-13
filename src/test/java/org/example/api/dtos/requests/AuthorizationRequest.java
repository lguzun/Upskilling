package org.example.api.dtos.requests;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class AuthorizationRequest {

    public String userName;
    public String password;

    /**
     * No args constructor for use in serialization
     *
     */
    public AuthorizationRequest() {
    }

    /**
     *
     * @param password
     * @param userName
     */
    public AuthorizationRequest(String userName, String password) {
        super();
        this.userName = userName;
        this.password = password;
    }

}