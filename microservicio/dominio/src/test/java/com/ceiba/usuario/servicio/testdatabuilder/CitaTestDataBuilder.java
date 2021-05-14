package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.time.LocalDateTime;

public class CitaTestDataBuilder {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private String metodopago;

    public CitaTestDataBuilder() {
        descripcion="Hola";
        fechaInicio=LocalDateTime.of(2021,4,21,16,06);
        fechaFinal=LocalDateTime.of(2021,4,21,17,06);
        valorAcordado=666.0;
        metodopago="credito";
    }

    public CitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder conFecha(LocalDateTime fechaInicio){
        this.fechaInicio = fechaInicio;
        return this;
    }

    public Cita build() {
        return new Cita(id, descripcion, fechaInicio, fechaFinal, valorAcordado, metodopago);
    }

    }

