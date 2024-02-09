package com.innoclique.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

/**
 *  @author Naveen Kumar Chintala
 */

@Data
@Entity
@Table(name = "users")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UserID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userID;

    @Column(name = "UserCode")
    private String userCode;

    @Column(name = "UserTypeID")
    private Integer userTypeID;

    @Column(name = "Password1")
    private String password1;

    @Column(name = "Password2")
    private String password2;

    @Column(name = "Alerts")
    private Integer alerts;

    @Column(name = "EmailAddress")
    private String emailAddress;

    @Column(name = "LastActivity")
    private Date lastActivity;

    @Column(name = "LastLogin")
    private Date lastLogin;

    @Column(name = "DateCreated")
    private Date dateCreated;

    @Column(name = "DateUpdated")
    private Date dateUpdated;

    @Column(name = "CreatedBy")
    private Integer createdBy;

}
