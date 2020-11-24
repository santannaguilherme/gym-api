package com.trainingpal.gym.controller;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.service.SiteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TeacherController
 */

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    
    private final SiteUserService service;

    @Autowired
    public TeacherController(SiteUserService service)  {
      this.service = service;
    }
    @PutMapping
    public void updateUser(@Valid @RequestBody UsuarioCreateRequest usuarioCreateRequest,Authentication authentication ) throws Exception {
      service.updateUser(authentication.getName(),usuarioCreateRequest);
    }
}