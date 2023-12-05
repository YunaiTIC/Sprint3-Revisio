package com.openwebinars.spring.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openwebinars.spring.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    // Métodos CRUD proporcionados por JpaRepository
}
