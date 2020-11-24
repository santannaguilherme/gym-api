package com.trainingpal.gym.controller;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.LoginRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.service.SiteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SiteUserController
 */
@RestController
@RequestMapping("/user")
public class SiteUserController {

  private final SiteUserService service;

  @Autowired
  public SiteUserController(SiteUserService service)  {
    this.service = service;
  }
  
  @PostMapping
  public void createUsuario(@Valid @RequestBody UsuarioCreateRequest usuarioCreateRequest) throws Exception {
    service.createUser(usuarioCreateRequest);
  }



  @PostMapping("/login")
  public User login(@Valid @RequestBody LoginRequest login) throws Exception {
    String email = login.getLogin();
    String senha = login.getPassword();
    return service.ValidateUser(email, senha);
  }

}