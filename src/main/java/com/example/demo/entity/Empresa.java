package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Empresa {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String job;
    private String description;
    private String location;

    @OneToMany(mappedBy = "empresa")
    private List<Ofertes> ofertes;

    public Empresa() {}

    public Empresa(String name, String job, String description, String location) {
        this.name = name;
        this.job = job;
        this.description = description;
        this.location = location;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public List<Ofertes> getOfertes() {
        return this.ofertes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOfertes(List<Ofertes> ofertes) {
        this.ofertes = ofertes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Empresa)) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(this.id, empresa.id) &&
                Objects.equals(this.name, empresa.name) &&
                Objects.equals(this.job, empresa.job) &&
                Objects.equals(this.description, empresa.description) &&
                Objects.equals(this.location, empresa.location);
    }
    
    
    
    
    

 

    public Empresa(Long id, String name, String job, String description, String location) {
        this.id = id;
        this.name = name;
        this.job = job;
        this.description = description;
        this.location = location;
        this.ofertes = new ArrayList<>();
    }



	@Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.job, this.description, this.location);
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + this.id +
                ", name='" + this.name + '\'' +
                ", job='" + this.job + '\'' +
                ", description='" + this.description + '\'' +
                ", location='" + this.location + '\'' +
                '}';
    }
}
