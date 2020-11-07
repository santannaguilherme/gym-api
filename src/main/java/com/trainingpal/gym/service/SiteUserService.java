package com.trainingpal.gym.service;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.entities.Usuario;

public class SiteUserService {

	public void createUser(@Valid UsuarioCreateRequest usuarioCreateRequest) {
	}

	public Usuario ValidateUser(String email, String senha) {
		return null;
	}

}
