package com.trainingpal.gym.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TRAINING")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @JoinColumn(name = "TeacherId", nullable = false)
    private Integer teacherId;
    
    @JoinColumn(name = "UserId", nullable = false)
    private Integer userId;

    @JoinColumn(name = "TrainingPeriodId", nullable = false)
    private Integer trainingPeriodId;

    @Column(name = "TrainingComment", nullable = false, length = 2000)
    private String TrainingComment;

}