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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Athlete
 */
@Data
@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "EXERCISE")
public class Exercise {

	
	public Exercise(String exerciseName, String image) {
		this.exerciseName = exerciseName;
		this.image = image;
	}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer exerciseId;

    @Column(name = "exerciseName", nullable = false, length = 60)
    private String exerciseName;

    @Column(nullable = false, length = 255)
    private String image;


}