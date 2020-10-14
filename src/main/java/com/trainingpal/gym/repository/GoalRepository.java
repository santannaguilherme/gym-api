package com.trainingpal.gym.repository; 

import com.trainingpal.gym.domain.entities.Goal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

}