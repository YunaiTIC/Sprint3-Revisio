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

import com.openwebinars.spring.entity.Ofertes;
import com.openwebinars.spring.repositorios.OfertesRepository;


@RestController
@RequestMapping("/ofertes")
public class OfertesController {
		
    private final OfertesRepository repository;

     OfertesController(OfertesRepository repository) {
        this.repository = repository;
    }

    // Obtener todas las ofertas
    @GetMapping("/ofertes")
    List<Ofertes> all() {
        return repository.findAll();
    }

    // Crear ofertas
    @PostMapping("/ofertes")
    public ResponseEntity<String> createOfertes(@RequestBody List<Ofertes> ofertesList) {
        repository.saveAll(ofertesList);
        return ResponseEntity.ok("Data inserted successfully");
    }


    // Obtener una oferta por ID
    @GetMapping("/ofertes/{id}")
    Ofertes one(@PathVariable Long id) {
        return repository.findById(id)
        		.orElse(null);
    }

    // Actualizar una oferta por ID
    @PutMapping("/ofertes/{id}")
    Ofertes replaceOfertes(@RequestBody Ofertes newOfertes, @PathVariable Long id) {
        return repository.findById(id)
                .map(ofertes -> {
                    ofertes.setOffer(newOfertes.getOffer());
                    ofertes.setDescription(newOfertes.getDescription());
                    return repository.save(ofertes);
                })
                .orElseGet(() -> {
                    newOfertes.setId(id);
                    return repository.save(newOfertes);
                });
        
        
        //Empresa s= repository.findById(id)
        //oferta.setEmpresa(s);
        //ofertadao.save(oferta)
    }

    // Eliminar una oferta por ID
    @DeleteMapping("/ofertes/{id}")
    void deleteOfertes(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
