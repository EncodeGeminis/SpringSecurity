package com.factory.geminis.controlempleados.service;

import java.util.List;

import com.factory.geminis.controlempleados.dominio.Catalogo;

public interface CatalogoService {

    //Funcionalidad basica 
    public void agregarProducto(Catalogo catalogo);
    public Catalogo buscarProducto(Catalogo catalogo);
    public void eliminarCatalogo(Catalogo catalogo);
    public List<Catalogo> listarCatalogos();
}
