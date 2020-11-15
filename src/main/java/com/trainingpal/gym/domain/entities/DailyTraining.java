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
@Table(name = "DailyTraining")
public class DailyTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DailyTrainingId", nullable = false)
    private Integer dailyTrainingId;

    @OneToOne()
    @JoinColumn(name = "trainingId", nullable = false)
    private Training training;
    
    @OneToOne()
    @JoinColumn(name = "AthleteId", nullable = false)
    private Athlete athlete;

    @Column(name = "TrainingDate", nullable = true)
    private Date trainingDate;

    @Column(name = "IsStarted", nullable = false)
    private Boolean isStarted;

    @Column(name = "IsFinished", nullable = false)
    private Boolean isFinished;
}