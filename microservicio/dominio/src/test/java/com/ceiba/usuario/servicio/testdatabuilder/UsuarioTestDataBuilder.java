package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private String telefono;
    private String metodoDePago;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "Emanuel";
        telefono = "3207788273";
        metodoDePago = "Credito";

    }
    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }
    public UsuarioTestDataBuilder conNombre(String nombre){
        this.nombreUsuario=nombre;
        return this;
    }



    public Usuario build() {
        return new Usuario(id,nombreUsuario, telefono, metodoDePago);
    }
}
