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
@Table(name = "screening")
public class Screening implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ScreeningID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long screeningID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Active")
    private Integer active;

    @Column(name = "LocationID")
    private Integer locationID;

}
