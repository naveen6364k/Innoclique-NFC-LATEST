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
@Table(name = "qoptions")
public class Qoptions implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "QOptionID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long QOptionID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private Integer status;

}
