package com.davi_souzadev.gestao_vagas.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
  

  //A anotação BEAN serve para dizer ao Spring que está configuração que estamos utilizando sobrescreve
  // uma configuração que já existe no Spring
  @Bean
  SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    http.csrf(csrf -> csrf.disable())
      .authorizeHttpRequests(auth -> {
        auth.requestMatchers("/candidate/").permitAll()
        .requestMatchers("/company/").permitAll();
        auth.anyRequest().authenticated();
      })
    ;
    return http.build();
  }

}