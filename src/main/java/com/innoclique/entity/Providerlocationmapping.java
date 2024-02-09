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
@Table(name = "providerlocationmapping")
public class Providerlocationmapping implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PLocationID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PLocationID;

    @Column(name = "LocationID")
    private Integer locationID;

    @Column(name = "ProviderID")
    private Integer providerID;

    @Column(name = "Active")
    private Integer active;

}
