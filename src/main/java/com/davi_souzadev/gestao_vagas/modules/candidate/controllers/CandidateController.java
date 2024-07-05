package com.davi_souzadev.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davi_souzadev.gestao_vagas.modules.candidate.CandidateEntity;
import com.davi_souzadev.gestao_vagas.modules.candidate.useCases.CreateCandidateUseCase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    // @GetMapping("/")
    // public ResponseEntity<List<CandidateEntity>> getAll() {
    //     var candidates = candidateRepository.findAll();
    //     return ResponseEntity.status(HttpStatus.OK).body(candidates);
    // }

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<String> delete(@PathVariable UUID id) {
    //     candidateRepository.deleteById(id);
    //     return ResponseEntity.status(HttpStatus.OK).body("Deletado com sucesso");
    // }
}
