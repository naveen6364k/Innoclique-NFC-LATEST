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
@Table(name = "patientcourseanswers")
public class Patientcourseanswers implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PCAnswerID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PCAnswerID;

    @Column(name = "CourseID")
    private Integer courseID;

    @Column(name = "CourseTypeID")
    private Integer courseTypeID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "CQuestionnaireID")
    private Float CQuestionnaireID;

    @Column(name = "CourseQoptionID")
    private Integer courseQoptionID;

    @Column(name = "DateCreated")
    private Date dateCreated;

    @Column(name = "DateUpdated")
    private Date dateUpdated;

}
