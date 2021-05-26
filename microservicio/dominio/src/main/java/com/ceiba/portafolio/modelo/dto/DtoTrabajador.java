package com.ceiba.portafolio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoTrabajador {

    private Long id;
    private String nombre;
    private String telefono;
    private String metodoDePago;

}
