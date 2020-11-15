package com.trainingpal.gym.service;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Exercice;
import com.trainingpal.gym.repository.ExerciceReposiroty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ExerciceService {

    private final ExerciceReposiroty exerciceReposiroty;

    @Autowired
    public ExerciceService(ExerciceReposiroty exerciceReposiroty) {
        this.exerciceReposiroty = exerciceReposiroty;
    }
    
    public List<Exercice> listExercices () {
        return exerciceReposiroty.findAll();
    }

    public Exercice findById(Integer id) throws Exception {
        Optional<Exercice> exercice = exerciceReposiroty.findById(id);
        return exercice.orElseThrow(() -> new Exception("Exercice Not found"));
    }

    public Exercice createAthlete(Exercice model) {
        return exerciceReposiroty.save(model);
    }

    public Exercice athletePut(Integer id, Exercice newExercice) throws Exception {
        Exercice exercice = findById(id);
        exercice.setExerciseName(newExercice.getExerciseName());
        

        return exerciceReposiroty.save(exercice);
    }
    
}