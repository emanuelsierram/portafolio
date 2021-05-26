package com.ceiba.portafolio.comando.fabrica;

import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.comando.ComandoCita;

import org.springframework.stereotype.Component;

@Component
public class FabricaCita {

    public Cita crear(ComandoCita comandoCita) {
        return new Cita(
                comandoCita.getId(),
                comandoCita.getDescripcion(),
                comandoCita.getFechaInicio(),
                comandoCita.getFechaFinal(),
                comandoCita.getValorAcordado(),
                comandoCita.getIdTrabajador()
        );
    }
}
