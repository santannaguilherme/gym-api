package com.trainingpal.gym.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * WeightResponse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeightResponse {

    private Integer exerciseId;

    private Integer currentWeight;
}