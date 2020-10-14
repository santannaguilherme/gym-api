package com.trainingpal.gym.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TRAINPERIOD")
public class TraininPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @Column(name = "AerobicalExercises", nullable = false, length = 2000)
    private String aerobicalExercises;

    @Column(name = "ShoulderExercises", nullable = false, length = 2000)
    private String shoulderExercises;

    @Column(name = "ChestExercises", nullable = false, length = 2000)
    private String chestExercises;

    @Column(name = "BicepsExercises", nullable = false, length = 2000)
    private String bicepsExercises;

    @Column(name = "TricepsExercises", nullable = false, length = 2000)
    private String tricepsExercises;

    @Column(name = "CalfExercises", nullable = false, length = 2000)
    private String calfExercises;

    @Column(name = "ThighExercises", nullable = false, length = 2000)
    private String thighExercises;

    @Column(name = "GluteusExercises", nullable = false, length = 2000)
    private String gluteusExercises;

    @Column(name = "BackExercises", nullable = false, length = 2000)
    private String backExercises;
    
    @Column(name = "DayOfWeek", nullable = false, length = 15)
    private String dayOfWeek;
}