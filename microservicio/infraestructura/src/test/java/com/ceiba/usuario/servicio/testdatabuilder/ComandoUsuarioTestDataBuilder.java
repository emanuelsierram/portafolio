package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Cita;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String telefono;


    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        telefono = "1234";
       // fecha = LocalDateTime.now();
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre,telefono);
    }
}
