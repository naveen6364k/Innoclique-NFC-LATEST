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
@Table(name = "patientalarms")
public class Patientalarms implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PAlarmID", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PAlarmID;

    @Column(name = "PLID")
    private Integer plid;

    @Column(name = "MedicationID")
    private Integer medicationID;

    @Column(name = "AlarmTime")
    private Date alarmTime;

    @Column(name = "DaysofWeek")
    private String daysofWeek;

    @Column(name = "IsEnabled")
    private Integer isEnabled;

}
