package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.response.ExerciceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/exercises")
public class ExercisesController {

    @GetMapping(value = "/{idExercice}")
    public ResponseEntity<ExerciceResponse> getById(@PathVariable Integer id) {
        ExerciceResponse e = new ExerciceResponse();
        return ResponseEntity.ok(e);

    }

    @GetMapping
    public ResponseEntity<List<ExerciceResponse>> list() {
        List<ExerciceResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
    }
}
