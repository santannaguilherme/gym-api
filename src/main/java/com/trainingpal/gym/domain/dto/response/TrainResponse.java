package com.trainingpal.gym.domain.dto.response;

import com.trainingpal.gym.domain.dto.request.ExercicesRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainResponse {
    private ExercicesRequest[] exercises;
}
