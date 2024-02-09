package com.innoclique.entity;

import lombok.Data;

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
@Table(name = "patientappointment")
public class Patientappointment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "AppointmentID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long appointmentID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "ProviderID")
    private Integer providerID;

    @Column(name = "AppointmentDateTime")
    private Date appointmentDateTime;

    @Column(name = "Status")
    private String status;

    @Column(name = "DateCreated")
    private Date dateCreated;

}
