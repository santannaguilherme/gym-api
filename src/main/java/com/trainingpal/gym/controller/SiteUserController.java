package com.trainingpal.gym.controller;

import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.LoginRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioAvatarRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.service.SiteUserService;
import com.trainingpal.gym.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

/**
 * SiteUserController
 */
// @RestController
// @RequestMapping("/user")
public class SiteUserController {

  private final SiteUserService service;
  private final UsuarioService usuarioService;

  @Autowired
  public SiteUserController(SiteUserService service, UsuarioService usuarioService)  {
    this.service = service;
    this.usuarioService = usuarioService;
  }
  
  @PostMapping
  public void createUsuario(@Valid @RequestBody UsuarioCreateRequest usuarioCreateRequest) {
    service.createUser(usuarioCreateRequest);
  }

  @PostMapping("/login")
  public User login(@Valid @RequestBody LoginRequest login) {
    String email = login.getEmail();
    String senha = login.getSenha();
    return service.ValidateUser(email, senha);
  }

  @ApiOperation("Alterar foto")
  @PutMapping("/{id}/avatar")
  public void editAvatarUsuario(@Valid @RequestParam("id") Integer id, @RequestBody UsuarioAvatarRequest usuarioAvaterRequest) {
    usuarioService.editAvatarUsuario(id, usuarioAvaterRequest);
  }

  @GetMapping()
  public List<User>  listUsers() {
    return usuarioService.findAll();
  }

}