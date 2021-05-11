package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.comando.ComandoCita;
import com.ceiba.usuario.modelo.entidad.Cita;

import org.springframework.stereotype.Component;

@Component
public class fabricaCita {

    public Cita crear(ComandoCita comandoCita) {
        return new Cita(
                comandoCita.getId(),
                comandoCita.getDescripcion(),
                comandoCita.getFechaInicio(),
                comandoCita.getFechaFinal(),
                comandoCita.getValorAcordado(),
                comandoCita.getUsuario()
        );
    }
}
