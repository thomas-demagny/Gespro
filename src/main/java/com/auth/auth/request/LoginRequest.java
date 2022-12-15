package com.auth.auth.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Login request.
 */
@Getter
@Setter
public class LoginRequest {
    
    private String username;

    
    private String password;


}
