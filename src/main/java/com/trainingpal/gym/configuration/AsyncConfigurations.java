package com.trainingpal.gym.configuration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import com.trainingpal.gym.domain.entities.Goal;
import com.trainingpal.gym.service.GoalService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfigurations implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncConfigurations.class);

    private final GoalService goalService;

    public AsyncConfigurations(GoalService goalService) {
        this.goalService = goalService;

    }

    @Bean
    public Executor taskExecutor() {
        LOGGER.debug("Creating");
        final ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("ExerciceThread-");
        executor.initialize();
        return executor;

    }

    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();

        CompletableFuture<Goal> page1 = goalService.createGoal(new Goal());

        CompletableFuture.allOf(page1).join();

        LOGGER.info("Elapsed time: " + (System.currentTimeMillis() - start));
        LOGGER.info("--> " + page1.get());

    }

}