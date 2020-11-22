package com.trainingpal.gym.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import com.trainingpal.gym.domain.dto.response.TrainigResponse;
import com.trainingpal.gym.domain.entities.DailyTraining;
import com.trainingpal.gym.domain.entities.User;

/**
 * DailyTrainingRepository
 */
@Repository
public interface DailyTrainingRepository extends JpaRepository<DailyTraining, Integer> {

	Optional<DailyTraining> findByAthleteAndIsStartedAndIsFinished(User user, boolean b, boolean c);

    
}