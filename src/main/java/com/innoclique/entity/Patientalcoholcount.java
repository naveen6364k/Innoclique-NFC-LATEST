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
@Table(name = "patientalcoholcount")
public class Patientalcoholcount implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "AlcoholCount")
    private Float alcoholCount;

    @Column(name = "ActivityDate")
    private Date activityDate;

}
