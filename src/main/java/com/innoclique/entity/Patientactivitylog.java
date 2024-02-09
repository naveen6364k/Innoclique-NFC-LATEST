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
@Table(name = "patientactivitylog")
public class Patientactivitylog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "LogID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "Method")
    private String method;

    @Column(name = "ActivityType")
    private String activityType;

    @Column(name = "ActivityDate")
    private Date activityDate;

    @Column(name = "Comments")
    private String comments;

}
