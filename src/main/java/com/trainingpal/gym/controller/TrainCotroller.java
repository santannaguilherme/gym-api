package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.request.TrainRequest;
import com.trainingpal.gym.domain.dto.response.TrainResponse;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/train")
public class TrainCotroller {


    @Autowired
    public TrainCotroller() {

    }
    @PostMapping
    public void post(@Valid @RequestBody TrainRequest model) {
    }

    @PostMapping("/{email}")
    public void complete(@PathVariable String email) {
    }

    @GetMapping(value = "/{idTrain}")
    public ResponseEntity<TrainResponse> getById(@PathVariable Integer id) {
        TrainResponse e = new TrainResponse();
        return ResponseEntity.ok(e);

    }


}