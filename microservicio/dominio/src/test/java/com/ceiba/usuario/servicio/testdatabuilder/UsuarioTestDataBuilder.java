package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
<<<<<<< HEAD
    private String telefono;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "Hola";
        telefono = "1234";

    }

    public UsuarioTestDataBuilder conTelefono(String telefono) {
        this.telefono = telefono;
=======
    private String clave;
    private LocalDateTime fecha;

    public UsuarioTestDataBuilder() {
        nombreUsuario = "1234";
        clave = "1234";
        fecha = LocalDateTime.now();
    }

    public UsuarioTestDataBuilder conClave(String clave) {
        this.clave = clave;
>>>>>>> b99d914c1ae58f56e41684276d6bdcfa6f832c1a
        return this;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
<<<<<<< HEAD
        return new Usuario(id,nombreUsuario, telefono);
=======
        return new Usuario(id,nombreUsuario, clave,fecha);
>>>>>>> b99d914c1ae58f56e41684276d6bdcfa6f832c1a
    }
}
