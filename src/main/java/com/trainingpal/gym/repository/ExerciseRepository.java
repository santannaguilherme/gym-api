package com.trainingpal.gym.repository; 

import com.trainingpal.gym.domain.entities.Exercise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

}