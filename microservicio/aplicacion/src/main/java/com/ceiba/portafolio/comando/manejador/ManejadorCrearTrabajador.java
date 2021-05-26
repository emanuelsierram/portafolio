package com.ceiba.portafolio.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.servicio.ServicioCrearTrabajador;
import org.springframework.stereotype.Component;

import com.ceiba.portafolio.comando.ComandoTrabajador;
import com.ceiba.portafolio.comando.fabrica.FabricaTrabajador;

@Component
public class ManejadorCrearTrabajador implements ManejadorComandoRespuesta<ComandoTrabajador, ComandoRespuesta<Long>> {

    private final FabricaTrabajador fabricaTrabajador;
    private final ServicioCrearTrabajador servicioCrearTrabajador;

    public ManejadorCrearTrabajador(FabricaTrabajador fabricaTrabajador, ServicioCrearTrabajador servicioCrearTrabajador) {
        this.fabricaTrabajador = fabricaTrabajador;
        this.servicioCrearTrabajador = servicioCrearTrabajador;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoTrabajador comandoTrabajador) {
        Trabajador trabajador = this.fabricaTrabajador.crear(comandoTrabajador);
        return new ComandoRespuesta<>(this.servicioCrearTrabajador.ejecutar(trabajador));
    }
}
