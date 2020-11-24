package com.trainingpal.gym.controller;

import com.trainingpal.gym.domain.dto.request.GoalRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/goal")
public class GoalController {

    @PostMapping
    public void post(@Valid @RequestBody GoalRequest model) {
    }
}
