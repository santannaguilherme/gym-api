package com.trainingpal.gym.configuration.security.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.trainingpal.gym.domain.entities.SiteRole;
import com.trainingpal.gym.service.SiteUserService;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

  // EXPIRATION_TIME = 10 dias
  static final long EXPIRATION_TIME = 860_000_000;
  static final String SECRET = "MySecret#@$!@aleatorio";
  static final String TOKEN_PREFIX = "Bearer";
  static final String HEADER_STRING = "Authorization";
  static final String AUTHORITIES_KEY = "scopes";

  public static void addAuthentication(HttpServletResponse response, Authentication auth) {
    final String authorities = auth.getAuthorities().stream().map(GrantedAuthority::getAuthority)
    .collect(Collectors.joining(","));
    String JWT = Jwts.builder().setSubject(auth.getName()).claim(AUTHORITIES_KEY, authorities)
    .signWith(SignatureAlgorithm.HS256, SECRET).setIssuedAt(new Date(System.currentTimeMillis()))
    .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME * 1000)).compact();

    response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    response.addHeader("access-control-expose-headers", "Authorization");
  }

  public static Authentication getAuthentication(HttpServletRequest request) {
    String token = request.getHeader(HEADER_STRING);

    if (token != null) {
      // faz parse do token
      String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
          .getSubject();

      if (user != null) {
        ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils
            .getWebApplicationContext(servletContext);
        SiteUserService userService = webApplicationContext.getBean(SiteUserService.class);

        List<SiteRole> roles = userService.rolesFrom(user);

        return new UsernamePasswordAuthenticationToken(user, null, roles);
      }
    }
    return null;
  }

}