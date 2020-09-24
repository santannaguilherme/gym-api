package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.request.CoachRequest;
import com.trainingpal.gym.domain.dto.request.TrainRequest;
import com.trainingpal.gym.domain.dto.response.CoachResponse;
import com.trainingpal.gym.domain.dto.response.ExerciceResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/coach")
public class CoachController {

    @GetMapping(value = "/{email}")
    public ResponseEntity<CoachResponse> getById(@PathVariable String email) {
        CoachResponse c = new CoachResponse();
        return ResponseEntity.ok(c);

    }

    @GetMapping()
    public ResponseEntity<List<CoachResponse>> list() {
        List<CoachResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
    }
    @PostMapping
    public void post(@Valid @RequestBody CoachRequest model) {
    }
}
