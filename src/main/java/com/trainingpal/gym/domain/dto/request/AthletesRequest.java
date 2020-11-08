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

    @NotEmpty()
    private Integer roleId;

    @NotEmpty()
    @Size(max = 500)
    private String name;

    @NotEmpty()
    private Integer age;

    @NotEmpty()
    @Size(max = 500)
    private String email;

    @NotEmpty()
    @Size(max = 500)
    private String phone;

    @NotEmpty()
    private Double weight;

    @NotEmpty()
    private Double height;
    
    @NotEmpty()
    @Size(max = 500)
    private String password;
}
