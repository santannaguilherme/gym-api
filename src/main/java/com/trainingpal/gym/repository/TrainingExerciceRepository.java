package com.trainingpal.gym.repository;

import java.util.List;

import com.trainingpal.gym.domain.entities.Training;
import com.trainingpal.gym.domain.entities.TrainingExercice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TrainingExerciceRepository
 */
public interface TrainingExerciceRepository extends JpaRepository<TrainingExercice,Integer>{

	List<TrainingExercice> findBytraining(Training training);

    
}