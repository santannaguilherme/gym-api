package com.trainingpal.gym.domain.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MyAthletesReponse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MyAthletesReponse {

    private List<UserResponse> athletes;
}