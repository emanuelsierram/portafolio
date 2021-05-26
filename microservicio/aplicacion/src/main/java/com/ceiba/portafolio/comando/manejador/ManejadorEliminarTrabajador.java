package com.ceiba.portafolio.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.portafolio.servicio.ServicioEliminarTrabajador;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarTrabajador implements ManejadorComando<Long> {

    private final ServicioEliminarTrabajador servicioEliminarTrabajador;

    public ManejadorEliminarTrabajador(ServicioEliminarTrabajador servicioEliminarTrabajador) {
        this.servicioEliminarTrabajador = servicioEliminarTrabajador;
    }

    public void ejecutar(Long idTrabajador) {
        this.servicioEliminarTrabajador.ejecutar(idTrabajador);
    }
}
