package com.trainingpal.gym.domain.dto.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainigRequest {

    @NotNull()
    private List<ExercicesRequest> exercices;

}
