package com.trainingpal.gym.domain.entities;

import java.util.Date;

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
@Table(name = "GOAL")
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;

    @JoinColumn(name = "TeacherId", nullable = false)
    private Integer teacherId;
    
    @JoinColumn(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "Goal", nullable = false, length = 20)
    private String goal;

    @Column(name = "RealizationDate", nullable = false)
    private Date realizationDate;

    @Column(name = "Weight", nullable = false)
    private Double weight;

} 