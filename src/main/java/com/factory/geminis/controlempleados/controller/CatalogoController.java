package com.factory.geminis.controlempleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.factory.geminis.controlempleados.service.CatalogoService;




@Controller
public class CatalogoController {

    @Autowired
    CatalogoService catalogoService;

    @GetMapping("/Catalogo")
    public String obtenerCatalogo(Model model) {
        //obtener el catalogo 
        var listaProductos=catalogoService.listarCatalogos();
        //se añade al model para mostrarlo en la vista 
        model.addAttribute("productos", listaProductos);
        model.addAttribute("TotalProductos", listaProductos.size());    
        return "Catalogo";
    }
}
