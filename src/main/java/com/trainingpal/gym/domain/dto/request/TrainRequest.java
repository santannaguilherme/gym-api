package com.trainingpal.gym.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrainRequest {

    @NotEmpty()
    @Size(max = 500)
    private String email;

    @NotEmpty()
    private ExercicesRequest[] exercises;
}
