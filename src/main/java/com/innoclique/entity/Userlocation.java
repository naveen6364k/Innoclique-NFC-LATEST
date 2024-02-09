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
@Table(name = "userlocation")
public class Userlocation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "ClientID")
    private Integer clientID;

    @Column(name = "LocationID")
    private Integer locationID;

    @Column(name = "Active")
    private Integer active;

}
