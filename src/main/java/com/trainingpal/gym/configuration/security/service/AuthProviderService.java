package com.trainingpal.gym.configuration.security.service;

import java.util.List;

import com.trainingpal.gym.domain.entities.SiteRole;
import com.trainingpal.gym.domain.entities.User;
import com.trainingpal.gym.service.SiteUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
public class AuthProviderService implements AuthenticationProvider {

  @Autowired
  private SiteUserService userService;

  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {

    String name = authentication.getName();
    String password = authentication.getCredentials().toString();

    User validUser = userService.ValidateUser(name, password);

    if (validUser != null) {
      List<SiteRole> roles = userService.rolesFrom(validUser.getEmail());
      return new UsernamePasswordAuthenticationToken(validUser.getEmail(), //
          validUser.getPassword(), roles);
    } else {
      throw new UsernameNotFoundException("Login e/ou Senha inválidos.");
    }
  }

  @Override
  public boolean supports(Class<?> auth) {
    return auth.equals(UsernamePasswordAuthenticationToken.class);
  }
}