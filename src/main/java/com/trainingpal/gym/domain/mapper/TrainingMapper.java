package com.trainingpal.gym.domain.mapper;

import com.trainingpal.gym.domain.dto.request.TrainigRequest;
import com.trainingpal.gym.domain.entities.Training;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class TrainingMapper {

    private final ModelMapper mapper;

    @Autowired
    public TrainingMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public Training fromDto(TrainigRequest trainigRequest) {
    return mapper.map(trainigRequest, Training.class);
  }


}