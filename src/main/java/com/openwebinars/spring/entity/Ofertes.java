package com.openwebinars.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ofertes")
public class Ofertes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String offer;
    private String description;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    @JsonIgnore
    private Empresa empresa;

    
    public Ofertes(String offer, String description, Empresa empresa) {
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



	public Ofertes() {
		super();
	}

    
    
//@Override
    //	public String toString() {
    //return "Ofertes [id=" + id + ", offer=" + offer + ", description=" + description + ", empresa=" + empresa + "]";
    //}

	

	
	
	
    
}
