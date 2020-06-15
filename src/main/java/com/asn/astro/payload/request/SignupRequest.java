package com.asn.astro.payload.request;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class SignupRequest {
 
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    @NotNull
    @AssertTrue
    private Boolean isPolicyAgree;
}
