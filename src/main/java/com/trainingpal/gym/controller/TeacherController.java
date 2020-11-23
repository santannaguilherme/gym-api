package com.trainingpal.gym.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.TeacherRequest;
import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.dto.response.TeacherResponse;
import com.trainingpal.gym.service.SiteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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