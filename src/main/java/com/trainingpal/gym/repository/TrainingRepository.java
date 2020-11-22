package com.trainingpal.gym.repository;

import com.trainingpal.gym.domain.entities.Training;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TrainingRepository
 */
public interface TrainingRepository extends JpaRepository<Training,Integer> {

    Training findByActiveAndAthleteIdAndTrainingType(Boolean active, Integer athleteId, String trainingType);
    
}