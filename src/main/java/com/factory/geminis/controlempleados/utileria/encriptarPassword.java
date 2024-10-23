package com.factory.geminis.controlempleados.utileria;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class encriptarPassword {
    public static void main(String[] args) {
       var pass= "diana";
       System.out.println("password: "+pass);
       System.out.println("password encriptado: "+encriptarPassword(pass));

    }
    public static String encriptarPassword(String pass){
        //clase para encriptar los password
        BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
        return encoder.encode(pass);
    }
}
