package com.davi_souzadev.gestao_vagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.davi_souzadev.gestao_vagas.exceptions.UserFoundException;
import com.davi_souzadev.gestao_vagas.modules.company.entities.CompanyEntity;
import com.davi_souzadev.gestao_vagas.modules.company.repositories.CompanyRepository;

@Service
public class CreateCompanyUseCase {

  @Autowired
  private CompanyRepository companyRepository;
  
  public CompanyEntity execute(CompanyEntity companyEntity) {
    
    this.companyRepository.findByUsernameOrEmail(companyEntity.getUsername(), companyEntity.getEmail()).
    ifPresent(company -> {
      throw new UserFoundException();
    });

    return this.companyRepository.save(companyEntity);
  }

}
