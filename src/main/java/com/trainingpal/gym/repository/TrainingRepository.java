package com.trainingpal.gym.repository;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Training;
import com.trainingpal.gym.domain.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TrainingRepository
 */
public interface TrainingRepository extends JpaRepository<Training,Integer> {

    Training findByActiveAndAthleteIdAndTrainingType(Boolean active, Integer athleteId, String trainingType);

	Optional<Training> findByActiveAndAthleteId(boolean bactive, Integer id);

	List<Training> findByTeacher(User user);
    
}