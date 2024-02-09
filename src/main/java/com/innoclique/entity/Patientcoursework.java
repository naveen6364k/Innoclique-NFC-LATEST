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
@Table(name = "patientcoursework")
public class Patientcoursework implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "CourseTypeID")
    private Integer courseTypeID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "CourseProgress")
    private Float courseProgress;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "DateCreated")
    private Date dateCreated;

    @Column(name = "DateUpdated")
    private Date dateUpdated;

}
