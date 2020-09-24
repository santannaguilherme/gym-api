package com.trainingpal.gym.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GoalRequest {

    @NotEmpty()
    @Size(max = 500)
    private String goal;
    @NotEmpty()
    private double weight;

    @NotEmpty()
    @Size(max = 500)
    private Date date;
}
