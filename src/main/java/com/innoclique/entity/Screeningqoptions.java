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
@Table(name = "screeningqoptions")
public class Screeningqoptions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ScreeningQoptionID", nullable = false)
    private Long screeningQoptionID;

    @Column(name = "ScreeningID")
    private Integer screeningID;

    @Column(name = "SQuestionnaireID")
    private Integer SQuestionnaireID;

    @Column(name = "OptionID")
    private Integer optionID;

    @Column(name = "OptionValue")
    private String optionValue;

    @Column(name = "OrderID")
    private Integer orderID;

    @Column(name = "Status")
    private Integer status;

}
