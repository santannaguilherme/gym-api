package com.trainingpal.gym.service;

import java.util.concurrent.CompletableFuture;

import com.trainingpal.gym.domain.entities.Goal;
import com.trainingpal.gym.repository.GoalRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoalService {

    private final GoalRepository goalRepository;

    private static final Logger logger = LoggerFactory.getLogger(GoalService.class);

    private final RestTemplate restTemplate;

    @Autowired
    public GoalService(RestTemplateBuilder restTemplateBuilder, GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<Goal> createGoal(Goal goal) throws InterruptedException {

        Goal results = goalRepository.save(goal);
        Thread.sleep(1000L);
        return CompletableFuture.completedFuture(results);
    }

}