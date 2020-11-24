package com.trainingpal.gym.domain.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainigResponse {
    private Integer trainingId;
    private Integer dailyTrainingId;
    private Boolean isStarted;
    private Boolean isFinished;
    private String trainingType;
    private List<TrainningExerciceResponse> exercises;

}
