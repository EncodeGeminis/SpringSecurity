package com.factory.geminis.controlempleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.factory.geminis.controlempleados.DAO.CatalogoDAO;
import com.factory.geminis.controlempleados.dominio.Catalogo;

@Service("CatalogoService")
public class CatalogoServiceImpl implements CatalogoService{

    @Autowired
    CatalogoDAO catalogoDao;

    @Override
    public void agregarProducto(Catalogo catalogo) {
        catalogoDao.save(catalogo);
    }

    @Override
    public Catalogo buscarProducto(Catalogo catalogo) {
        return catalogoDao.findById(catalogo.getIdProducto()).orElse(null);
    }

    @Override
    public void eliminarCatalogo(Catalogo catalogo) {    
        catalogoDao.delete(catalogo);
    }

    @Override
    public List<Catalogo> listarCatalogos() {
        //cast para convertir el objeto en tipo lista
        var productos = (List<Catalogo>) catalogoDao.findAll();
        return productos;
    }

}
