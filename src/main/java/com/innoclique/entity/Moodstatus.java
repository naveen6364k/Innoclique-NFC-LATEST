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
@Table(name = "moodstatus")
public class Moodstatus implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MoodStatusID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moodStatusID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Active")
    private Integer active;

}
