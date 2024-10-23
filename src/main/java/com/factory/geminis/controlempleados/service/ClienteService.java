package com.factory.geminis.controlempleados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.factory.geminis.controlempleados.DAO.ClienteDao;
import com.factory.geminis.controlempleados.dominio.Cliente;
import com.factory.geminis.controlempleados.dominio.Rol;

import jakarta.transaction.Transactional;

@Service("UserDetailsService")
public class ClienteService implements UserDetailsService {

    @Autowired
    ClienteDao clienteDao;
    //con este metodo se hara interacion con la tabla de usuario y roles
    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Cliente cliente = clienteDao.findByUsername(username);
        if(cliente == null){
            throw new UsernameNotFoundException(username);
        }
        //se tienen que envolver los roles en la clase GrantedAuthority
        var roles= new ArrayList<GrantedAuthority>();
        for(Rol rol: cliente.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));   
            }
            //se define de manera automatica en spring por lo que se le pasa la informacion del cliente
            //que nosotros proporcionamos.
            return new User(cliente.getUsername(),cliente.getPass(),roles);
        }
}
