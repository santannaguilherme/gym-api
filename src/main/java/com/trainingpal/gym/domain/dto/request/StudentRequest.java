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
public class StudentRequest {

    @NotEmpty()
    @Size(max = 500)
    private String email;

    @NotEmpty()
    private int age;

    @NotEmpty()
    @Size(max = 500)
    private String name;

    @NotEmpty()
    @Size(max = 500)
    private  String phone;

    @NotEmpty()
    private double weight;

    @NotEmpty()
    private double height;

    @NotEmpty()
    @Size(max = 500)
    private String rg;
}