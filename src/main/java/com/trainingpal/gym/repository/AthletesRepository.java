package com.trainingpal.gym.repository;

import java.util.Optional;

import com.trainingpal.gym.domain.entities.Athlete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AthletesRepository extends JpaRepository<Athlete, Integer> {
    Athlete findByEmail(String email);
}