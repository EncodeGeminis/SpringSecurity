package com.factory.geminis.controlempleados.dominio;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "rol")
public class Rol implements Serializable{
    //definicion de atributos
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idRol;
    @NotEmpty
    private String nombre;
    //no se utiliza el mapeo de id_usuario 
    public Long getIdRol() {
        return idRol;
    }
    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Rol() {
    }
    public Rol(Long idRol, @NotEmpty String nombre) {
        this.idRol = idRol;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Rol [idRol=" + idRol + ", nombre=" + nombre + "]";
    }
}
