package com.factory.geminis.controlempleados.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.factory.geminis.controlempleados.dominio.Catalogo;

@Repository
public interface CatalogoDAO extends JpaRepository<Catalogo, Long> {
}
