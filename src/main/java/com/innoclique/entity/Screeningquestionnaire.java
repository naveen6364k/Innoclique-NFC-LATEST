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
@Table(name = "screeningquestionnaire")
public class Screeningquestionnaire implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SQuestionnaireID", nullable = false)
    private Long SQuestionnaireID;

    @Column(name = "ScreeningID")
    private Integer screeningID;

    @Column(name = "Description")
    private String description;

    @Column(name = "OptionID")
    private Integer optionID;

    @Column(name = "OrderID")
    private Integer orderID;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Question")
    private String question;

}
