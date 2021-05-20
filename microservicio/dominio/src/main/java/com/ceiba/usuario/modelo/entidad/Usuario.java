package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_METODO_DE_PAGO = "Se debe ingresar el nombre de usuario";

    private Long id;
    private String nombre;
    private String telefono;
    private String metodoDePago;

    public Usuario(Long id, String nombre, String telefono, String metodoDePago) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);
        validarObligatorio(metodoDePago, SE_DEBE_INGRESAR_EL_METODO_DE_PAGO);
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.metodoDePago = metodoDePago;

    }

}
