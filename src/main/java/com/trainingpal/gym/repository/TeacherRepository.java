package com.trainingpal.gym.repository; 

import java.util.Optional;

import com.trainingpal.gym.domain.entities.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

	Optional<Teacher> findByEmail(String email);

}