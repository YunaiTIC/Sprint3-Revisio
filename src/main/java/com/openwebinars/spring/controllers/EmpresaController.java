package com.openwebinars.spring.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openwebinars.spring.entity.Empresa;
import com.openwebinars.spring.repositorios.EmpresaRepository;

@RequestMapping("/empresas")
@RestController
public class EmpresaController {
	


  private final EmpresaRepository repository;

  EmpresaController(EmpresaRepository repository) {
    this.repository = repository;
  }

  // Aggregate root
  @GetMapping("/empresas")
  List<Empresa> all() {
    return repository.findAll();
  }

  @PostMapping("/empresas")
  public ResponseEntity<String> createEmpresas(@RequestBody List<Empresa> empresas) {
    repository.saveAll(empresas);
    return ResponseEntity.ok("Data inserted successfully");
  }

  // Single item
  @GetMapping("/empresas/{id}")
  Empresa one(@PathVariable Long id) {
    return repository.findById(id)
            .orElse(null);
  }

  @PutMapping("/empresas/{id}")
  Empresa replaceEmpresa(@RequestBody Empresa newEmpresa, @PathVariable Long id) {
    return repository.findById(id)
            .map(empresa -> {
              empresa.setName(newEmpresa.getName());
              empresa.setJob(newEmpresa.getJob());
              empresa.setDescription(newEmpresa.getDescription());
              empresa.setLocation(newEmpresa.getLocation());
              return repository.save(empresa);
            })
            .orElseGet(() -> {
              newEmpresa.setId(id);
              return repository.save(newEmpresa);
            });
  }

  @DeleteMapping("/empresas/{id}")
  void deleteEmpresa(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
