package com.trainingpal.gym.configuration.security;

import com.trainingpal.gym.configuration.security.filters.JWTAuthenticationFilter;
import com.trainingpal.gym.configuration.security.filters.JWTLoginFilter;
import com.trainingpal.gym.configuration.security.service.AuthProviderService;

import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private AuthProviderService authProvider;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.cors().configurationSource(corsConfigurationSource()).and().csrf().disable().authorizeRequests()
        .antMatchers("/user","/user/login", "/v2/api-docs", "/exercises", "/configuration/ui", "/swagger-resources", "/swagger-resources/**",
            "/configuration/security", "/swagger-ui.html", "/webjars/**")
        .permitAll() // acesso para o swagger
        .antMatchers("/").permitAll().anyRequest().authenticated().and()

        // filtra requisições de login
        .addFilterBefore(new JWTLoginFilter("/user/login", authenticationManager()),
            UsernamePasswordAuthenticationFilter.class)
        // filtra outras requisições para verificar a presença do JWT no header
        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

  }
  
  @Bean
  public CorsConfigurationSource corsConfigurationSource() {
      final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

      CorsConfiguration config = new CorsConfiguration();
      config.setAllowedOrigins(Arrays.asList("*"));
      config.setAllowedMethods(Arrays.asList("GET","POST", "OPTIONS", "PUT"));
      config.setAllowedHeaders(Collections.singletonList("*"));

      source.registerCorsConfiguration("/**", config);
      return source;
  }

  @Override
  @Autowired
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProvider);
  }

  @Bean
  public PasswordEncoder encoder() {
    return new BCryptPasswordEncoder();
  }

}