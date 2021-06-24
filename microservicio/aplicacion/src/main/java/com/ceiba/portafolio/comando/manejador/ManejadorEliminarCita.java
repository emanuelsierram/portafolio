package com.ceiba.portafolio.comando.manejador;

import com.ceiba.portafolio.servicio.ServicioEliminarCita;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCita {

    private final ServicioEliminarCita servicioEliminarCita;

    public ManejadorEliminarCita(ServicioEliminarCita servicioEliminarCita) {
        this.servicioEliminarCita = servicioEliminarCita;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarCita.ejecutar(id);
    }
}
