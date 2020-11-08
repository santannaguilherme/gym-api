package com.trainingpal.gym.service;

import java.util.List;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.UsuarioAvatarRequest;
import com.trainingpal.gym.domain.entities.Usuario;

import org.springframework.stereotype.Service;
@Service
public class UsuarioService {

	public void editAvatarUsuario(@Valid Integer id, UsuarioAvatarRequest usuarioAvaterRequest) {
	}

	public List<Usuario> findAll() {
		return null;
	}

}
