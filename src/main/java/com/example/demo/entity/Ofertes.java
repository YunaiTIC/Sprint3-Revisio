package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class Ofertes {

    @Id
    @GeneratedValue
    private Long id;

    private String offer;
    private String description;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;


    public Ofertes(Long id, String offer, String description, Empresa empresa) {
        this.id = id;
        this.offer = offer;
        this.description = description;
        this.empresa = empresa;
    }



    public Long getId() {
        return this.id;
    }

    public String getOffer() {
        return this.offer;
    }

    public String getDescription() {
        return this.description;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

	@Override
	public String toString() {
		return "Ofertes [id=" + id + ", offer=" + offer + ", description=" + description + ", empresa=" + empresa + "]";
	}

	

	
	
	
    
}
