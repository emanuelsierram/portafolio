package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String telefono;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "Hola";
        telefono = "1234";

    }

    public UsuarioTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario, telefono);
    }
}
