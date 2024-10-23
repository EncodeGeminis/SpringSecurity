package com.factory.geminis.controlempleados.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.factory.geminis.controlempleados.dominio.Cliente;

public interface ClienteDao extends JpaRepository<Cliente, Long>{
    Cliente findByUsername(String username);
}
