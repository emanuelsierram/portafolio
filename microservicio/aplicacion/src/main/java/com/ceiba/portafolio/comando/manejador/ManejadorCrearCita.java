

package com.ceiba.portafolio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.portafolio.modelo.entidad.Cita;
import com.ceiba.portafolio.servicio.ServicioCrearCita;
import com.ceiba.portafolio.comando.ComandoCita;
import com.ceiba.portafolio.comando.fabrica.FabricaCita;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearCita implements ManejadorComandoRespuesta<ComandoCita, ComandoRespuesta<Long>> {

    private final FabricaCita fabricaCita;
    private final ServicioCrearCita servicioCrearCita;

    public ManejadorCrearCita(FabricaCita fabricaCita, ServicioCrearCita servicioCrearCita) {
        this.fabricaCita = fabricaCita;
        this.servicioCrearCita = servicioCrearCita;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCita comandoCita) {
        Cita cita = this.fabricaCita.crear(comandoCita);
        return new ComandoRespuesta<>(this.servicioCrearCita.ejecutar(cita));
    }

}
