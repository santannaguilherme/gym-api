package com.trainingpal.gym.domain.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TrainingId", nullable = false)
    private Integer trainingId;

    @OneToOne()
    @JoinColumn(name = "TeacherId", nullable = false)
    private User teacher;
    
    @OneToOne()
    @JoinColumn(name = "AthleteId", nullable = false)
    private User athlete;

    @Column(name = "TrainingValidity", nullable = true)
    private Date trainingValidity;

    @Column(name = "TrainingType", nullable = false, length = 60)
    private String trainingType;

    @Column(name = "Active", nullable = false)
    private Boolean active;

}