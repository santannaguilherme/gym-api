package com.trainingpal.gym.repository; 

import com.trainingpal.gym.domain.entities.Evolution;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvolutionRepository extends JpaRepository<Evolution, Integer> {

}