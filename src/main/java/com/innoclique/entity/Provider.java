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
@Table(name = "provider")
public class Provider implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ProviderID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerID;

    @Column(name = "ClientID")
    private Integer clientID;

    @Column(name = "Provider")
    private String provider;

    @Column(name = "Active")
    private Integer active;

}
