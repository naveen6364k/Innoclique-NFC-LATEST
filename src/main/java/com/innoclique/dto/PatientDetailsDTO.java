package com.innoclique.dto;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Naveen Kumar Chintala
 */

@Getter
@Setter
public class PatientDetailsDTO {
    private Long patientID;

    private Integer patientAccountNo;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String address;

    private Integer stateID;

    private String city;

    private String zip;

    private String mobileAppKey;

    private Date dateCreated;

    private Integer status;

}
