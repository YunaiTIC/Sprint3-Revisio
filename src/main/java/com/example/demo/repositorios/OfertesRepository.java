package com.example.demo.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Ofertes;


public interface OfertesRepository extends JpaRepository<Ofertes, Long> {

}
