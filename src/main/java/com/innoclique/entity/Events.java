package com.innoclique.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

/**
 *  @author Naveen Kumar Chintala
 */

@Data
@Entity
@Table(name = "events")
public class Events implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "EventID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventID;

    @Column(name = "EventName")
    private String eventName;

    @Column(name = "DateCreated")
    private Date dateCreated;

}
