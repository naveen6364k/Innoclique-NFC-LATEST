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
@Table(name = "client")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ClientID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientID;

    @Column(name = "Client")
    private String client;

    @Column(name = "Active")
    private Integer active;

}
