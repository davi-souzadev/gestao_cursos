package com.davi_souzadev.gestao_vagas.exceptions;

public class UserFoundException extends RuntimeException {
    public UserFoundException() {
      super("Usuário ou senha já existem");
    }
}
