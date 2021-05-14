package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Cita{

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private String metodopago;

    public Cita(Long id,String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFinal, Double valorAcordado, String metodopago) {
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(fechaInicio, SE_DEBE_INGRESAR_LA_CLAVE);
        validarObligatorio(fechaFinal, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        validarObligatorio(valorAcordado, SE_DEBE_INGRESAR_LA_FECHA_CREACION);
        this.id = id;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.valorAcordado = valorAcordado;
        this.metodopago =metodopago;

    }

}
