package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.response.ExerciceResponse;
import com.trainingpal.gym.domain.entities.Exercise;
import com.trainingpal.gym.service.ExerciseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

	private final ExerciseService exerciseService;
	
	@Autowired
	public ExercisesController(ExerciseService exerciseService) {
		this.exerciseService = exerciseService;
	}
	
    @GetMapping(value = "/{idExercice}")
    public ResponseEntity<ExerciceResponse> getById(@PathVariable Integer id) {
        ExerciceResponse e = new ExerciceResponse();
        return ResponseEntity.ok(e);

    }

    @GetMapping
    public ResponseEntity<List<Exercise>> list() {
        List<Exercise> l = this.exerciseService.listExercices();
        return ResponseEntity.ok(l);
    }
    
    @PostMapping
    public ResponseEntity<Exercise> saveExercise(@RequestPart(value="exerciseName") String exerciseName, @RequestPart(value="file") MultipartFile file) {
    	Exercise exercise = this.exerciseService.addExercise(exerciseName, file);
    	
        return ResponseEntity.ok(exercise);
    }
    
    @DeleteMapping(value = "/{exerciseId}")
    public ResponseEntity<String> deleteExercise(@PathVariable Integer exerciseId) {
    	
    	try {
    		this.exerciseService.deleteExercise(exerciseId);    		
    		return ResponseEntity.ok("Successfully deleted.");
    	} catch (Exception e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
    							.body("An Error Ocurred.");
    	}
    }
    
    @PutMapping(value = "/{exerciseId}")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Integer exerciseId,
    		@RequestPart(value="exerciseName") String exerciseName, @RequestPart(value="file") MultipartFile file) {
    	
    	try {
    		Exercise exercise = new Exercise();
        	exercise.setExerciseId(exerciseId);
        	exercise.setExerciseName(exerciseName);
    		Exercise updatedExercise = this.exerciseService.updateExercise(exercise, file);    
    		return ResponseEntity.ok(updatedExercise);
    	} catch (Exception e) {
    		
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(null);
    	}
    	
    }
}
