package com.ceiba.usuario.modelo.dto;

import com.ceiba.usuario.modelo.entidad.Cita;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class DtoUsuario {

    private Long id;
    private String nombre;
    private String telefono;
    private String metodopago;

}
