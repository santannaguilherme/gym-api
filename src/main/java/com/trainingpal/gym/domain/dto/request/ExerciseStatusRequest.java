package com.trainingpal.gym.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ExerciseStatusRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseStatusRequest {

    private Integer exerciseId;
    private Boolean completed;
}