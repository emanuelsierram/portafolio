package com.ceiba.portafolio.servicio.testdatabuilder;

import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.modelo.entidad.Trabajador;

import java.time.LocalDateTime;

public class CitaTestDataBuilder {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private Integer idtrabajador;

    public CitaTestDataBuilder() {
        descripcion="Esta es una descripcion";
        fechaInicio=LocalDateTime.of(2021,4,20,10,20);
        fechaFinal=LocalDateTime.of(2021,4,20,12,20);
        valorAcordado=200.0;
        idtrabajador=1;
    }

    public CitaTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CitaTestDataBuilder conFecha(LocalDateTime fechaInicio){
        this.fechaInicio = fechaInicio;
        return this;
    }

    public CitaTestDataBuilder conDescripcion(String descripcion){
        this.descripcion = descripcion;
        return this;


    }
    public CitaTestDataBuilder conFechas(LocalDateTime fechaInicio, LocalDateTime fechaFinal){

        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        return  this;
    }

    public Cita build() {
        return new Cita(id, descripcion, fechaInicio, fechaFinal, valorAcordado, idtrabajador);
    }

    }

