package com.trainingpal.gym.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TeacherResponse
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherResponse {

    private String name;

    private Integer age;

    private String email;

    private String phone;

    private Double weight;

    private Double height;
}