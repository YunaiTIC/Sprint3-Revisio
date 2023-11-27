package com.example.demo.spring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.entity.Empresa;
import com.example.demo.entity.Ofertes;
import com.example.demo.repositorios.EmpresaRepository;
import com.example.demo.repositorios.OfertesRepository;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmpresaRepository empresaRepository, OfertesRepository ofertesRepository) {
      return args -> {
    	  Empresa empresa = new Empresa(2L, "Empresa nova", "Programador Junior", "Barcelona", "Itic");
          Ofertes ofertes = new Ofertes(2L, "2", "Busquem estudiants", empresa);

          // Set the relationship
          empresa.getOfertes().add(ofertes);
          ofertes.setEmpresa(empresa);

          log.info("Preloading " + empresaRepository.save(empresa));
          log.info("Preloading " + ofertesRepository.save(ofertes));
      };
  }
}