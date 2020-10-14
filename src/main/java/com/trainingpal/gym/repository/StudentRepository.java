package com.trainingpal.gym.repository; 


import com.trainingpal.gym.domain.entities.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

}