package com.ceiba.portafolio.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.servicio.ServicioActualizarCita;
import com.ceiba.portafolio.comando.ComandoCita;
import com.ceiba.portafolio.comando.fabrica.FabricaCita;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCita implements ManejadorComando<ComandoCita> {

    private final FabricaCita fabricaCita;
    private final ServicioActualizarCita servicioActualizarCita;

    public ManejadorActualizarCita(FabricaCita fabricaCita, ServicioActualizarCita servicioActualizarCita) {
        this.fabricaCita = fabricaCita;
        this.servicioActualizarCita = servicioActualizarCita;
    }

    public void ejecutar(ComandoCita comandoCita) {
        Cita cita = this.fabricaCita.crear(comandoCita);

        this.servicioActualizarCita.ejecutar(cita);
    }
}
