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
@Table(name = "patientlocation")
public class Patientlocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PLID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long plid;

    @Column(name = "PatientID")
    private Integer patientID;

    @Column(name = "ProviderID")
    private Integer providerID;

    @Column(name = "LocationID")
    private Integer locationID;

    @Column(name = "DefaultLocation")
    private Integer defaultLocation;

    @Column(name = "Status")
    private Integer status;

}
