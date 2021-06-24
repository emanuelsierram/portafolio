package com.ceiba.configuracion;


import com.ceiba.portafolio.puerto.repositorio.RepositorioCita;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;
import com.ceiba.portafolio.servicio.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BeanServicio {


    @Bean
    public ServicioCrearTrabajador servicioCrearTrabajador(RepositorioTrabajador repositorioTrabajador) {
        return new ServicioCrearTrabajador(repositorioTrabajador);
    }


    @Bean
    public ServicioActualizarTrabajador servicioActualizartrabajador(RepositorioTrabajador repositorioTrabajador) {
        return new ServicioActualizarTrabajador(repositorioTrabajador);
    }

    @Bean
    public ServicioCrearCita servicioCrearCita(RepositorioCita repositorioCita, RepositorioTrabajador repositorioTrabajador) {
        return new ServicioCrearCita(repositorioCita, repositorioTrabajador);
    }

    @Bean
    public ServicioActualizarCita servicioActualizarCita (RepositorioCita repositorioCita){
        return  new ServicioActualizarCita(repositorioCita);
    }

    @Bean
    public ServicioEliminarCita servicioEliminarCita (RepositorioCita repositorioCita){
        return  new ServicioEliminarCita(repositorioCita);
    }






}
