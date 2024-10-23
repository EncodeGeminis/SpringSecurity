package com.factory.geminis.controlempleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    //cargar usuarios desde bd
    //interface de spring para recuperar el user 
    @Autowired
    private UserDetailsService userDetailsService;

    // encriptar la contraseña 
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    
    //se le pasa un argumento automatico 
    @Autowired
    public void configurationGlobal(AuthenticationManagerBuilder build) throws Exception{
        build.userDetailsService(userDetailsService);   
    }
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/editar/**", "/agregarUsuario/**", "/eliminarUsuario/**")
                    .hasRole("ADMIN")
                .requestMatchers("/", "/ver/**")
                    .hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
            )
            .formLogin(login -> login
                .loginPage("/login")
                .defaultSuccessUrl("/index", true)
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .exceptionHandling(handling -> handling
                .accessDeniedHandler(accessDeniedHandler()) // Manejador de errores personalizado
            );

        return http.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        AccessDeniedHandlerImpl accessDeniedHandler = new AccessDeniedHandlerImpl();
        accessDeniedHandler.setErrorPage("/errores/403"); // Página de error personalizada
        return accessDeniedHandler;
    }
}
//metodo de cargar en memoria usuarios y roles
/*
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

 * @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.withUsername("geminis")
            .password("{noop}gema")
            .roles("ADMIN", "USER")
            .build();

        UserDetails user2 = User.withUsername("diana")
            .password("{noop}dia")
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
 */
