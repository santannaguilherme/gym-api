package com.trainingpal.gym.domain.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DeleteUserRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteUserRequest {

    @NotEmpty()
    @Size(max = 500)
    private String email;
}