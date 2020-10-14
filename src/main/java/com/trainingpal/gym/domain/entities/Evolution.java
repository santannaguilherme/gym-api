package com.trainingpal.gym.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "EVOLUTION")
public class Evolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Integer id;


    @JoinColumn(name = "UserId", nullable = false)
    private Integer userId;

    @Column(name = "Weight", nullable = false)
    private Double weight;

    @Column(name = "Imc", nullable = false, length = 20)
    private String imc;

    @Column(name = "Score", nullable = false)
    private Double score;

} 