package com.factory.geminis.controlempleados.dominio;

import javax.validation.constraints.NotEmpty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "catalogo")
public class Catalogo {
    //definicion de atributos
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long IdProducto;
    
    @NotEmpty
    @Column(name = "nombre_producto")
    private String nombreProducto;
    @NotEmpty
    @Column(name = "cantidad_producto")
    private String cantidadProducto;
    @NotEmpty
    @Column(name = "precio_producto")
    private String precioProducto;
    //definicion de Constructor
    public Catalogo(){}
    public Catalogo(Long IdProducto, String nombreProducto, String cantidadProducto, String precioProducto){
        this.IdProducto=IdProducto;
        this.nombreProducto=nombreProducto;
        this.precioProducto=precioProducto;
        this.cantidadProducto=cantidadProducto;
    }

    //definicion de metodos get y set
    public void setIdProducto(Long IdProducto){
        this.IdProducto=IdProducto;
    }
    public Long getIdProducto(){
        return IdProducto;
    }
    public void setNombreProducto(String nombreProducto){
        this.nombreProducto=nombreProducto;
    }
    public String getNombreProducto(){
        return nombreProducto;
    }
    public String getCantidadProducto() {
        return cantidadProducto;
    }
    public void setCantidadProducto(String cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }
    public String getPrecioProducto() {
        return precioProducto;
    }
    public void setPrecioProducto(String precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    
}
