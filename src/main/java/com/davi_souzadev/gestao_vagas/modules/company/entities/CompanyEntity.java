package com.davi_souzadev.gestao_vagas.modules.company.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "company")
public class CompanyEntity {
  @Id
  @GeneratedValue(strategy =  GenerationType.UUID)
  private UUID id;

  @NotBlank
  @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
  private String username;

  @Email(message = "O campo [email] deve conter um e-mail válido!")
  private String email;

  @Length(min = 8, max = 32)
  private String password;

  @NotBlank
  private String website;

  @NotBlank
  private String name;
  private String description;

  @CreationTimestamp
  private LocalDateTime createdAt;
}
