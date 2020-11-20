package com.trainingpal.gym.domain.mapper;

import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.dto.response.UserResponse;
import com.trainingpal.gym.domain.entities.User;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class UserMapper {

    private final ModelMapper mapper;

    @Autowired
    public UserMapper(ModelMapper mapper) {
    this.mapper = mapper;
  }

  public UserResponse toDto(User usuario) {
    return mapper.map(usuario, UserResponse.class);
  }

  public User fromDto(UsuarioCreateRequest usuarioCreateRequest) {
    return mapper.map(usuarioCreateRequest, User.class);
  }


}