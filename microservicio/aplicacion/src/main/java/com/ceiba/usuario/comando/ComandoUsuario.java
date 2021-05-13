package com.ceiba.usuario.comando;

import java.util.List;

import com.ceiba.usuario.modelo.entidad.Cita;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoUsuario{

    private Long id;
    private String nombre;
    private String telefono;
    private String metodoPago;


}
