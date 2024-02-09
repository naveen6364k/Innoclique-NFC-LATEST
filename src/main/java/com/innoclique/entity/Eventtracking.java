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
@Table(name = "eventtracking")
public class Eventtracking implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ETrackingID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ETrackingID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "EventID")
    private Integer eventID;

    @Column(name = "ActivityDateTime")
    private Date activityDateTime;

    @Column(name = "DateCreated")
    private Date dateCreated;

}
