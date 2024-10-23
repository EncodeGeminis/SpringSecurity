package com.factory.geminis.controlempleados.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.factory.geminis.controlempleados.DAO.IUsuarioDAO;
import com.factory.geminis.controlempleados.dominio.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    //inyectamos el Dao al service para usar los metodos de spring
    @Autowired
    private IUsuarioDAO usuarioDAO;
    @Override
    @Transactional(readOnly = true)
    public List<Usuario> listaUsuario() {
        //se hace el cast de tipo objeto a lista
        var usuarios = (List<Usuario>)usuarioDAO.findAll();
        return usuarios;
    }
    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }
    @Override
    @Transactional(readOnly = true)
    public Usuario buscarUsuario(Usuario usuario) {
            return usuarioDAO.findById(usuario.getId()).orElse(null);
    }
    @Override
    public void eliminarUsuario(Usuario usuario) {
        usuarioDAO.delete(usuario);
    }

}
