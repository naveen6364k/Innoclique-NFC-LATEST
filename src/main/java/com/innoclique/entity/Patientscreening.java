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
@Table(name = "patientscreening")
public class Patientscreening implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PScreeningID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PScreeningID;

    @Column(name = "ScreeningID")
    private Integer screeningID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "ScreeningProgress")
    private Integer screeningProgress;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "DateCreated")
    private Date dateCreated;

    @Column(name = "DateUpdated")
    private Date dateUpdated;

    @Column(name = "Questionnaire")
    private String questionnaire;

}
