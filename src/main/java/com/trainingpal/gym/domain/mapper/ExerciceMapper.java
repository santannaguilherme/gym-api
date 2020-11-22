package com.trainingpal.gym.domain.mapper;

import com.trainingpal.gym.domain.dto.request.AthletesRequest;
import com.trainingpal.gym.domain.dto.request.ExercicesRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.dto.response.ExerciceResponse;
import com.trainingpal.gym.domain.dto.response.UserResponse;
import com.trainingpal.gym.domain.entities.Exercise;
import com.trainingpal.gym.domain.entities.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ExerciceMapper {

    private final ModelMapper mapper;

    @Autowired
    public ExerciceMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public ExerciceResponse toDto(Exercise exercise) {
    return mapper.map(exercise, ExerciceResponse.class);
  }

  public Exercise fromDto(ExercicesRequest exercicesRequest) {
    return mapper.map(exercicesRequest, Exercise.class);
  }

 


}