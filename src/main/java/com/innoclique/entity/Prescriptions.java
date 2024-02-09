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
@Table(name = "prescriptions")
public class Prescriptions implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PrescriptionID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long prescriptionID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "MedicationID")
    private Integer medicationID;

    @Column(name = "StartDate")
    private Date startDate;

    @Column(name = "EndDate")
    private Date endDate;

    @Column(name = "ProviderID")
    private Integer providerID;

    @Column(name = "Direction")
    private String direction;

    @Column(name = "Dosage")
    private String dosage;

    @Column(name = "WithMeal")
    private Integer withMeal;

    @Column(name = "DateCreated")
    private Date dateCreated;

}
