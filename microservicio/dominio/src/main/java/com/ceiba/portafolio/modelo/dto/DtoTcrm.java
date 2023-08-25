package com.ceiba.portafolio.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@ToString
public class DtoTcrm implements Serializable {

    private String unidad;
    private Float valor;

}
