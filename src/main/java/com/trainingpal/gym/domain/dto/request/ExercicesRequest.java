package com.trainingpal.gym.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExercicesRequest {

    @NotEmpty()
    private Integer exerciseId;
    @NotEmpty()
    private Integer weight;
    @NotEmpty()
    private Integer quantity;
}
