package com.factory.geminis.controlempleados.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;

import com.factory.geminis.controlempleados.dominio.Usuario;
import com.factory.geminis.controlempleados.service.UsuarioService;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {
    //se inyecta el servicio a utilizar
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model model, @AuthenticationPrincipal UserDetails userDetails) {
        // Obtener la lista de usuarios
        var lista = usuarioService.listaUsuario();

        // Añadir la lista al modelo para mostrar en la vista
        model.addAttribute("usuarios", lista);
        //variable que guarda el saldo total
        var saldoTotal=0D;
        for(var l: lista){
            saldoTotal+=l.getSaldo();
        }
        model.addAttribute("saldoTotal", saldoTotal);
        model.addAttribute("totalClientes", lista.size());
        // Obtener el nombre de usuario y añadirlo al modelo
        if (userDetails != null) {
            model.addAttribute("usuarioLogin", userDetails.getUsername());
        }

        return "Index";
    }
    //metodo que crea el objeto usuario para posteriormente llenarlo con el form
    @GetMapping("/agregarUsuario")
    public String agregarUsuario(Usuario usuario){
        return "modificarUsuario";
    }
    //metodo post que recibe la informacion del form y la manda al UsuarioService
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@Valid Usuario usuario, Errors errors){
        if(errors.hasErrors()){
            return "modificarUsuario";
        }
        usuarioService.agregarUsuario(usuario);
        return "redirect:/";
    }   
    //metodo para modificar los datos de un usuario 
    @GetMapping("/editar/{id}")
    public String editar(Usuario usuario, Model model){
        usuario=usuarioService.buscarUsuario(usuario);
        model.addAttribute("usuario", usuario);
        return "modificarUsuario";
    }
    //metodo para eliminar un registro de persona en la base de datos
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminar(Usuario usuario){
        usuarioService.eliminarUsuario(usuario);
        return "redirect:/";
    }
}
