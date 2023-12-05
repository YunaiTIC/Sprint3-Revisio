package com.openwebinars.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openwebinars.spring.entity.Empresa;
import com.openwebinars.spring.entity.Ofertes;
import com.openwebinars.spring.repositorios.EmpresaRepository;
import com.openwebinars.spring.repositorios.OfertesRepository;

@RestController
@RequestMapping("/api/empresas")
public class ApiController {

    @Autowired
    public EmpresaRepository empresaRepository;

    @Autowired
    private OfertesRepository ofertesRepository;

    @PostMapping
    public ResponseEntity<String> crearEmpresa(@RequestBody Empresa empresa) {
        empresaRepository.save(empresa);
        return ResponseEntity.ok("Empresa creada");
    }

    @GetMapping
    public ResponseEntity<List<Empresa>> obtenerEmpresas() {
        List<Empresa> lista = empresaRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (empresaRepository.existsById(id)) {
            empresa.setId(id);
            empresaRepository.save(empresa);
            return ResponseEntity.ok("Empresa actualizada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    @PostMapping("/{empresaId}/ofertes")
    public ResponseEntity<String> agregarOferta(@PathVariable Long empresaId, @RequestBody Ofertes ofertes) {

        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        if (empresa != null) {
            ofertes.setEmpresa(empresa);
            ofertesRepository.save(ofertes);
            return ResponseEntity.ok("Oferta agregada a la empresa " + empresaId);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{empresaId}/ofertes")
    public ResponseEntity<List<Ofertes>> obtenerOfertasPorEmpresa(@PathVariable Long empresaId) {

        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        if (empresa != null) {
            List<Ofertes> lista = ofertesRepository.findByEmpresa(empresa);
            return ResponseEntity.ok(lista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{empresaId}/ofertes/{ofertaId}")
    public ResponseEntity<String> actualizarOferta(@PathVariable Long empresaId, @PathVariable Long ofertaId, @RequestBody Ofertes ofertes) {

        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        if (empresa != null) {
            ofertes.setEmpresa(empresa);
            ofertes.setId(ofertaId);
            ofertesRepository.save(ofertes);
            return ResponseEntity.ok("Oferta actualizada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{empresaId}/ofertes/{ofertaId}")
    public ResponseEntity<String> eliminarOferta(@PathVariable Long empresaId, @PathVariable Long ofertaId) {

        Empresa empresa = empresaRepository.findById(empresaId).orElse(null);
        if (empresa != null) {
            ofertesRepository.deleteById(ofertaId);
            return ResponseEntity.ok("Oferta eliminada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/{empresaId}")
    public ResponseEntity<String> eliminarEmpresa(@PathVariable Long empresaId) {
        
        List<Ofertes> ofertes = ofertesRepository.findByEmpresa_Id(empresaId);
        if (!ofertes.isEmpty()) {

            return ResponseEntity.badRequest().body("No es pot eliminar una empresa amb ofertes de feina");
        }

        empresaRepository.deleteById(empresaId);
        return ResponseEntity.ok("Empresa eliminada");
    }
}
