package com.trainingpal.gym.service;

import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.entities.SiteRole;
import com.trainingpal.gym.domain.entities.User;

import org.springframework.stereotype.Service;
@Service
public class SiteUserService {

	public void createUser(@Valid UsuarioCreateRequest usuarioCreateRequest) {
	}

	public User ValidateUser(String email, String senha) {
		return null;
	}

	public List<SiteRole> rolesFrom(String email) {
		return null;
	}

}
