package com.ceiba.configuracion;

import com.ceiba.usuario.puerto.dao.DaoCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {


    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }


    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita, RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearCita(repositorioCita, repositorioUsuario);
    }

    @Bean
    public ServicioActualizarCita servicioActualizarCita (RepositorioCita repositorioCita){
        return  new ServicioActualizarCita(repositorioCita);
    }






}
