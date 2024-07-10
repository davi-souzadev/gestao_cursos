package com.davi_souzadev.gestao_vagas.modules.company.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateJobDTO {

  private String description;
  private String level;
  private String benefits;
  
}
