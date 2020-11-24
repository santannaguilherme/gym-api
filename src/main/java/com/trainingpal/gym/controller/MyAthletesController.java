package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.response.MyAthletesReponse;
import com.trainingpal.gym.service.TrainingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AthletesController
 */

@RestController
@RequestMapping("/my-athletes")
public class MyAthletesController {

    private final TrainingService trainingService;

    @Autowired
    public MyAthletesController(TrainingService trainingService) {

        this.trainingService = trainingService;
    }


    @GetMapping
    public ResponseEntity<MyAthletesReponse> getById(Authentication authentication) {
        
        return ResponseEntity.ok(trainingService.getMyAthletes(authentication.getName()));

    }
}