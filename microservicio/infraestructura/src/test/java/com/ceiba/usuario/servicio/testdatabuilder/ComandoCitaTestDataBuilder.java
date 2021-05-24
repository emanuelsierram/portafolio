package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoCitaTestDataBuilder {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private String metodoPago;


    public ComandoCitaTestDataBuilder() {
        descripcion = UUID.randomUUID().toString();
        fechaInicio = LocalDateTime.of(2020,12,20,13,00);
        fechaFinal = LocalDateTime.of(2020,12,20,15,00);
        valorAcordado = 900.0;
        metodoPago = "Credito";

        // fecha = LocalDateTime.now();
    }

    public ComandoCitaTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ComandoCita build() {
        return new ComandoCita(id,descripcion,fechaInicio,fechaFinal,valorAcordado,metodoPago);
    }
}
