package com.trainingpal.gym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.AthletesRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.dto.response.AthletesResponse;
import com.trainingpal.gym.domain.entities.Training;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.domain.mapper.TrainingMapper;
import com.trainingpal.gym.domain.mapper.UserMapper;
import com.trainingpal.gym.service.SiteUserService;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AthletesController
 */

@RestController
@RequestMapping("/athletes")
public class AthletesController {

    private final TrainingService trainingService;

    @Autowired
    public AthletesController(TrainingService trainingService) {

        this.trainingService = trainingService;
    }

    @GetMapping()
    public ResponseEntity<List<AthletesResponse>> list() {
        List<AthletesResponse> l = new ArrayList<>();
        return ResponseEntity.ok(l);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AthletesResponse> getById(@PathVariable int id) {
        AthletesResponse c = new AthletesResponse();
        return ResponseEntity.ok(c);

    }

    @DeleteMapping(value = "/{id}")
    public void deletById(@PathVariable Integer id) {
    }

    @PostMapping
    public ResponseEntity<AthletesResponse> post(@Valid @RequestBody AthletesRequest model,
            Authentication authentication) throws Exception {

        return ResponseEntity.ok(trainingService.createAthlete(model, authentication.getName()));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<AthletesResponse> updateById(@PathVariable Integer id,
            @Valid @RequestBody AthletesRequest model) {
        return ResponseEntity.ok(new AthletesResponse());
    }

}