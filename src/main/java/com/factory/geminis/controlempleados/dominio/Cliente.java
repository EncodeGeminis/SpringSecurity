package com.factory.geminis.controlempleados.dominio;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Cliente implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    
    @NotEmpty
    private String username;
    @NotEmpty
    private String pass;
    //se hace el mapeo de la relacion entre la clase de usuario y de rol
    //Relacion de uno a mucho(OneToMany)
    @OneToMany
    //indica la columna que relacionara ambas tablas
    @JoinColumn(name = "id_usuario")
    private List<Rol> roles;
    public Long getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
    public List<Rol> getRoles() {
        return roles;
    }
    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }
    public Cliente() {
    }
    public Cliente(Long idUsuario, @NotEmpty String username, @NotEmpty String pass, List<Rol> roles) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.pass = pass;
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "Cliente [idUsuario=" + idUsuario + ", username=" + username + ", pass=" + pass + ", roles=" + roles
                + "]";
    }
    
}
