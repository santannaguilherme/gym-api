package com.trainingpal.gym.repository; 

import com.trainingpal.gym.domain.entities.Exercice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExerciceReposiroty extends JpaRepository<Exercice, Integer> {

}