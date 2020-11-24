package com.trainingpal.gym.domain.dto.request;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TrainReal
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainRealRequest {

    private Integer dailyTrainingId;
    private Boolean isFinished;
    private List<ExerciseStatusRequest> exercises;
}