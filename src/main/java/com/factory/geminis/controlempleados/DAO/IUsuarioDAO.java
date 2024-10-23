package com.factory.geminis.controlempleados.DAO;

import org.springframework.data.repository.CrudRepository;

import com.factory.geminis.controlempleados.dominio.Usuario;
//se genera la clase que extiende del repositorio crud
public interface IUsuarioDAO extends CrudRepository<Usuario, Long> {

}
