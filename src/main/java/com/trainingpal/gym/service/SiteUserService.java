package com.trainingpal.gym.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.trainingpal.gym.domain.dto.request.UsuarioCreateRequest;
import com.trainingpal.gym.domain.entities.SiteRole;
import com.trainingpal.gym.domain.entities.SiteUserRole;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.domain.mapper.UserMapper;
import com.trainingpal.gym.repository.SiteRoleRepository;
import com.trainingpal.gym.repository.SiteUserRoleRepository;
import com.trainingpal.gym.repository.UserRepository;
import com.trainingpal.gym.utils.SiteRoles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SiteUserService {
	private final SiteRoleRepository siteRoleRepository;
	private final PasswordEncoder passEncoder;
	private final UserMapper mapper;
	private final UserRepository userRepository;
	private final SiteUserRoleRepository siteUserRoleRepository;

	@Autowired
	public SiteUserService(SiteUserRoleRepository siteUserRoleRepository, //
			SiteRoleRepository siteRoleRepository, PasswordEncoder passEncoder, //
			UserMapper mapper, UserRepository userRepository) {

		this.siteUserRoleRepository = siteUserRoleRepository;
		this.siteRoleRepository = siteRoleRepository;
		this.passEncoder = passEncoder;
		this.mapper = mapper;
		this.userRepository = userRepository;
	}

	public User createUser(UsuarioCreateRequest usuarioCreateRequest) throws Exception {
		isNewUsuario(usuarioCreateRequest.getEmail());
		User newUser = mapper.fromDto(usuarioCreateRequest);

		newUser.setPassword(passEncoder.encode(newUser.getPassword()));
		newUser = userRepository.save(newUser);

		Set<SiteUserRole> roles = new HashSet<SiteUserRole>();
		String roleString;
		switch (usuarioCreateRequest.getRoleId()) {
		case 0:
			roleString = SiteRoles.APP_STUDENT;
			break;
		case 1:
			roleString = SiteRoles.APP_TEACHER;
			break;
		case 2:
			roleString = SiteRoles.APP_STAFF;
			break;
		default:
			roleString = SiteRoles.APP_STUDENT;
			break;
		}
		System.out.println(roleString);

		roles.add(getUserRole(newUser, roleString));
		System.out.println("Rola - "+roles.toString());
		siteUserRoleRepository.saveAll(roles);

		newUser.setRoles(roles);
		
		return newUser;
	}

	public SiteRole getRole(String role) {
		Optional<SiteRole> siteRole = siteRoleRepository.findById(role);
		if (siteRole.isPresent())
			return siteRole.get();
		else
			return siteRoleRepository.save(new SiteRole(role));
	}

	private SiteUserRole getUserRole(User usr, String role) {
		SiteRole siteRole = getRole(role);
		return SiteUserRole.builder().siteUserId(usr.getId()).siteRoleId(siteRole).build();
	}

	public List<SiteRole> rolesFrom(String usrName) {
		User user = userRepository.findByEmail(usrName);
		if (user == null)
			return new ArrayList<SiteRole>();
		else
			return user.getRoles().stream() //
					.map(x -> x.getSiteRoleId()).collect(Collectors.toList());
	}

	// public List<SiteRole> rolesFrom(SiteUser usr) {
	// return usr.getRoles().stream() //
	// .map(x -> x.getSiteRole()).collect(Collectors.toList());
	// }

	public User ValidateUser(String email, String senha) throws Exception {
		User user = userRepository.findByEmail(email);
		if (passEncoder.matches(senha, user.getPassword())) {
			return user;
		} else
			throw new Exception("Usuário ou senha inexistentes");
	}

	public void isNewUsuario(String email) throws Exception {
		User usuario = userRepository.findByEmail(email);
		if (usuario != null) {
			throw new Exception("E-mail já cadastrado");
		}
	}

	public User findByEmail(String email){
		return userRepository.findByEmail(email);
	}

}
