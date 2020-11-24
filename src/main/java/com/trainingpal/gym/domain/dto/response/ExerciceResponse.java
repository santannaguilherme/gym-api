package com.trainingpal.gym.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciceResponse {
    private Integer exerciseId;
    private String exerciseName;
    private String exerciseImage;
}
