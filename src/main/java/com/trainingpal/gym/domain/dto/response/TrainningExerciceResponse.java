package com.trainingpal.gym.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainningExerciceResponse {
    private Integer exerciseId;
    private String exerciseName;
    private Integer weight;
    private Integer repetitions;
    private Integer series;
    private String description;
    private String teacherName;
    private String exerciseImage;
}
