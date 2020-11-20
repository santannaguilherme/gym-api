package com.trainingpal.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainingpal.gym.domain.entities.DailyTraining;

/**
 * DailyTrainingRepository
 */
@Repository
public interface DailyTrainingRepository extends JpaRepository<DailyTraining, Integer> {

    
}