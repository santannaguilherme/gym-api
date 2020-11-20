package com.trainingpal.gym.service;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Training;
import com.trainingpal.gym.repository.TrainingRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TrainingService
 */
@Service
public class TrainingService {

    
    private final TrainingRepository trainingRepository;

    @Autowired
    public TrainingService(TrainingRepository trainingRepository){
        this.trainingRepository = trainingRepository;
    }
    
    public List<Training> listAthletes() {
        return trainingRepository.findAll();
    }

    public Training findById(Integer id) throws Exception {
        Optional<Training> training = trainingRepository.findById(id);
        return training.orElseThrow(() -> new Exception("Training Not found"));
    }

    public Training createAthlete(Training model) {
        return trainingRepository.save(model);
    }

    public Training athletePut(Integer id, Training newTraining) throws Exception {
        Training training = findById(id);
        training.setActive(newTraining.getActive());

        return trainingRepository.save(training);
    }
    
}