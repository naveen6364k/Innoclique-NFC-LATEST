package com.innoclique.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * @author Naveen Kumar Chintala
 */

@Data
@Entity
@Table(name = "statemaster")
public class Statemaster implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "stateid", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateid;

    @Id
    @Column(name = "StateID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stateID;

    @Column(name = "State")
    private String state;

    @Column(name = "Active")
    private Integer active;

}
