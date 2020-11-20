package com.trainingpal.gym.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrainingExercice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "ExerciseId", nullable = false)
    private Exercise exercice;

    @ManyToOne()
    @JoinColumn(name = "TrainingId", nullable = false)
    private Training training;

    @Column(name = "PreviousWeight", nullable = false)
    private Double previousWeight;

    @Column(name = "Weight", nullable = false)
    private Double weight;

    @Column(name = "Repetions", nullable = false)
    private Integer repetions;

    @Column(name = "Series", nullable = false)
    private Integer series;

}