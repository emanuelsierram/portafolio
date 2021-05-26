package com.ceiba.portafolio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoCita {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private Integer idTrabajador;




}
