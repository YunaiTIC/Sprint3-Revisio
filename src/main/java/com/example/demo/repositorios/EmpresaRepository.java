package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
