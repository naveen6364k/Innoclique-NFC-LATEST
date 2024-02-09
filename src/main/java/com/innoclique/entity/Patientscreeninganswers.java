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
@Table(name = "patientscreeninganswers")
public class Patientscreeninganswers implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PSAnswerID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PSAnswerID;

    @Column(name = "ScreeningID")
    private Integer screeningID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "SQuestionnaireID")
    private Integer SQuestionnaireID;

    @Column(name = "ScreeningQoptionID")
    private Integer screeningQoptionID;

    @Column(name = "DateCreated")
    private Date dateCreated;

    @Column(name = "DateUpdated")
    private Date dateUpdated;

}
