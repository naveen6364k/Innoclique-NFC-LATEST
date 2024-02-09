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
@Table(name = "usersecuritygroupmapping")
public class Usersecuritygroupmapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UGroupID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UGroupID;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "SecurityGroup")
    private Integer securityGroup;

    @Column(name = "Active")
    private Integer active;

    @Column(name = "DateCreated")
    private Date dateCreated;

    @Column(name = "DateUpdated")
    private Date dateUpdated;

    @Column(name = "CreatedBy")
    private Integer createdBy;

}
