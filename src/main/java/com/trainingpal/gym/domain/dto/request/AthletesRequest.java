package com.trainingpal.gym.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AthletesRequest {

    private Integer roleId;

    @NotEmpty()
    @Size(max = 500)
    private String name;

    private Integer age;

    @NotEmpty()
    @Size(max = 500)
    private String email;

    @NotEmpty()
    @Size(max = 500)
    private String phone;

    private Double weight;

    private Double height;

    @NotEmpty()
    @Size(max = 500)
    private String password;

    private TrainigRequest trainingA;
    private TrainigRequest trainingB;
    private TrainigRequest trainingC;
}
