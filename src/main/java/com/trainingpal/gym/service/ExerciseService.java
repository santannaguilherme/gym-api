package com.trainingpal.gym.service;

import java.util.List;
import java.util.Optional;

import com.trainingpal.gym.domain.entities.Exercise;
import com.trainingpal.gym.repository.ExerciseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;
    private final AmazonClientService amazonClientService;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository, AmazonClientService amazonClientService) {
        this.exerciseRepository = exerciseRepository;
        this.amazonClientService = amazonClientService;
    }
    
    public Exercise addExercise(String exerciseName, MultipartFile file) {
    	String imageUrl = this.amazonClientService.uploadFile(file);
    	Exercise exercise = new Exercise(exerciseName, imageUrl);
    	this.exerciseRepository.save(exercise);
    	return exercise;
    }
    
    public List<Exercise> listExercices () {
        return exerciseRepository.findAll();
    }

    public Exercise findById(Integer id) throws Exception {
        Optional<Exercise> exercise = exerciseRepository.findById(id);
        return exercise.orElseThrow(() -> new Exception("Exercice Not found"));
    }

    public Exercise createAthlete(Exercise model) {
        return exerciseRepository.save(model);
    }
    
    public Exercise deleteExercise(Integer exerciseId) throws Exception {
    	Exercise exercise = this.findById(exerciseId);
    	this.deleteExerciseImage(exercise.getImage());
    	
    	this.exerciseRepository.delete(exercise);
    	return exercise;
    }
    
    public Exercise updateExercise(Exercise exercise, MultipartFile file) throws Exception {
    	Exercise currentExercise = this.findById(exercise.getExerciseId());
    	this.deleteExerciseImage(currentExercise.getImage());
    	String imageUrl = this.amazonClientService.uploadFile(file);
    	Exercise newExercise = new Exercise(currentExercise.getExerciseId(), exercise.getExerciseName(), imageUrl);
    	this.exerciseRepository.save(newExercise);
    	return newExercise;
    }

    public Exercise athletePut(Integer id, Exercise newExercice) throws Exception {
    	Exercise exercice = findById(id);
        exercice.setExerciseName(newExercice.getExerciseName());
        
        return exerciseRepository.save(exercice);
    }
    
    private void deleteExerciseImage(String exerciseUrl) {
    	this.amazonClientService.deleteFile(exerciseUrl
    			.replace("https://gympal-images.s3.amazonaws.com/", ""));
    }
    
}