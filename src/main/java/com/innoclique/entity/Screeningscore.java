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
@Table(name = "screeningscore")
public class Screeningscore implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ScreeningID")
    private Integer screeningID;

    @Column(name = "ScreeningOption")
    private String screeningOption;

    @Column(name = "Score")
    private Float score;

    @Column(name = "Color")
    private String color;

    @Column(name = "Description")
    private String description;

}
