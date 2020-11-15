package com.trainingpal.gym.service;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Teacher;
import com.trainingpal.gym.repository.TeacherRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> listAthletes() {
        return teacherRepository.findAll();
    }

    public Teacher findById(Integer id) throws Exception {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.orElseThrow(() -> new Exception("Athelte Not found"));
    }

    public Teacher createTeacher(Teacher model) {
        return teacherRepository.save(model);
    }

    public Teacher athletePut(String email, Teacher newAthelte) throws Exception {
        Teacher teacher = findByEmail(email);
        teacher.setName(newAthelte.getName());
        teacher.setEmail(newAthelte.getEmail());
        teacher.setAge(newAthelte.getAge());
        teacher.setHeight(newAthelte.getHeight());
        teacher.setWeight(newAthelte.getWeight());
        teacher.setPhone(newAthelte.getPhone());

        return teacherRepository.save(teacher);
    }

    private Teacher findByEmail(String email) throws Exception {
        Optional<Teacher> teacher = teacherRepository.findByEmail(email);
        return teacher.orElseThrow(() -> new Exception("Athelte Not found"));
    }
    
}