package com.trainingpal.gym.controller;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.TrainRealRequest;
import com.trainingpal.gym.domain.dto.request.TrainigRequest;
import com.trainingpal.gym.domain.dto.request.WeightRequest;
import com.trainingpal.gym.domain.dto.response.TrainigResponse;
import com.trainingpal.gym.domain.dto.response.WeightResponse;
import com.trainingpal.gym.service.TrainingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TrainnigController
 */

@RestController
@RequestMapping("/my-trainnig")
public class TrainnigController {
    
    private final TrainingService trainingService;

    @Autowired
    public TrainnigController(TrainingService trainingService) {

        this.trainingService = trainingService;
    }
    @GetMapping()
    public ResponseEntity<TrainigResponse> list( Authentication authentication) throws Exception {
        return ResponseEntity.ok(trainingService.getByUser(authentication.getName()));
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<TrainigResponse> getById(@PathVariable int id) {
        TrainigResponse c = new TrainigResponse();
        return ResponseEntity.ok(c);

    }

    @DeleteMapping(value = "/{id}")
	public void deletById(@PathVariable Integer id) {
    }
    
    @PostMapping
	public void post(@Valid @RequestBody TrainRealRequest model) throws Exception {
		trainingService.finishTraining(model);
    }
    
    @PutMapping
	public ResponseEntity<WeightResponse> updateWeight(@Valid @RequestBody WeightRequest model) throws Exception {

		return ResponseEntity.ok(trainingService.updateWeight(model));
    }
    
    @PostMapping("/start/{id}")
	public ResponseEntity<TrainigResponse> post(@PathVariable String id, Authentication authentication)
            throws Exception {

		return ResponseEntity.ok(trainingService.getByTypeUser(id,authentication.getName()));
    }
    

}