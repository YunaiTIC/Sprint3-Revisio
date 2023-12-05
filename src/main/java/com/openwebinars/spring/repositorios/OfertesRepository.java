package com.openwebinars.spring.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openwebinars.spring.entity.Empresa;
import com.openwebinars.spring.entity.Ofertes;


public interface OfertesRepository extends JpaRepository<Ofertes, Long> {

    List<Ofertes> findByEmpresa(Empresa empresa);

    List<Ofertes> findByEmpresa_Id(Long empresaId);
    //void deleteByUniversity(Empresa empr);

	//void deleteOferta(Long empresaId, Long ofertaId);

	//void updateOferta(Long empresaId, Long ofertaId, Ofertes ofertes);

	//List<Ofertes> getOfertesByEmpresa(Long empresaId);

	//void addOferta(Long empresaId, Ofertes ofertes);
	
}
