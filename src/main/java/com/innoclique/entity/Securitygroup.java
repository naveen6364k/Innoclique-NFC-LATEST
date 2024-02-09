package com.innoclique.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;

/**
 *  @author Naveen Kumar Chintala
 */
@Data
@Entity
@Table(name = "securitygroup")
public class Securitygroup implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SecurityGroupID", nullable = false)
    private Long securityGroupID;

    @Column(name = "GroupName")
    private String groupName;

    @Column(name = "Active")
    private Integer active;

}
