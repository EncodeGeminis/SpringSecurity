package com.factory.geminis.controlempleados.service;

import java.util.List;


import com.factory.geminis.controlempleados.dominio.Usuario;

public interface UsuarioService {
    //funcionalidad crud basica
    public List<Usuario> listaUsuario();
    public void agregarUsuario(Usuario usuario);
    public Usuario buscarUsuario(Usuario usuario);
    public void eliminarUsuario(Usuario usuario);
}
