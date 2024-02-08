package com.innoclique.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


/**
 * @author Naveen Kumar Chintala
 */

@Getter
@Setter
@ToString
public class UserDetails {

    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
    private Boolean emailverified;
    private Boolean enabled;
    
}
