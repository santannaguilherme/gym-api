package com.trainingpal.gym.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WeightRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeightRequest {

    private Integer trainingId;

    private Integer exerciseId;

    private Integer currentWeight;
    
}