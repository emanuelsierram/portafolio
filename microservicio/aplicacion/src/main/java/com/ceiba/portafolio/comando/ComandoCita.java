package com.ceiba.portafolio.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCita {

    private Long id;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private Double valorAcordado;
    private Integer idTrabajador;
}
