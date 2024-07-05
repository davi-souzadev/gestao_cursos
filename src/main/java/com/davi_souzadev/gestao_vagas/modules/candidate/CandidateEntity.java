package com.davi_souzadev.gestao_vagas.modules.candidate;


import lombok.Data;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @NotBlank
    @Pattern(regexp = "\\S+", message = "O campo [username] não deve conter espaços")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido!")
    private String email;

    @Length(min = 8, max = 16)
    private String password;
    
    private String description;
}
