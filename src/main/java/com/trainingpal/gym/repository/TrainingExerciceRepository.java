package com.trainingpal.gym.repository;

import com.trainingpal.gym.domain.entities.TrainingExercice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TrainingExerciceRepository
 */
public interface TrainingExerciceRepository extends JpaRepository<TrainingExercice,Integer>{

    
}