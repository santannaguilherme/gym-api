package com.trainingpal.gym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.TrainigRequest;
import com.trainingpal.gym.domain.dto.response.TrainigResponse;
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
    public ResponseEntity<List<TrainigResponse>> list() {
        List<TrainigResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
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
	public ResponseEntity<TrainigResponse> post(@Valid @RequestBody TrainigRequest model) {
		
		return ResponseEntity.ok(new TrainigResponse());
    }
    
    @PutMapping(value = "/{id}")
	public ResponseEntity<TrainigResponse> updateById(@PathVariable Integer id,
			@Valid @RequestBody TrainigRequest model) {
		return ResponseEntity.ok(new TrainigResponse());
    }
    
    @PostMapping("/start/{id}")
	public ResponseEntity<TrainigResponse> post(@PathVariable String id, Authentication authentication)
            throws Exception {

		return ResponseEntity.ok(trainingService.getByTypeUser(id,authentication.getName()));
    }
    

}