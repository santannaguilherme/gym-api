package com.trainingpal.gym.domain.dto.response;

import com.trainingpal.gym.domain.entities.Training;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AthletesResponse {
    private UserResponse user;
    private Training t;
}
