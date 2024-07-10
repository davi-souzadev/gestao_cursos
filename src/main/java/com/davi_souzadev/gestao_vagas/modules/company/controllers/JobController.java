package com.davi_souzadev.gestao_vagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi_souzadev.gestao_vagas.modules.company.dto.CreateJobDTO;
import com.davi_souzadev.gestao_vagas.modules.company.entities.JobEntity;
import com.davi_souzadev.gestao_vagas.modules.company.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/job")
public class JobController {
  
  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
    try {
      var companyId = request.getAttribute("company_id");

      var jobEntity = JobEntity.builder()
        .benefits(createJobDTO.getBenefits())
        .companyId(UUID.fromString(companyId.toString()))
        .description(createJobDTO.getDescription())
        .level(createJobDTO.getLevel())
        .build();

      var result = this.createJobUseCase.execute(jobEntity);
      System.out.println(result.toString());
      return ResponseEntity.created(null).body(result);
    } catch (Exception e) {

      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
  
}
