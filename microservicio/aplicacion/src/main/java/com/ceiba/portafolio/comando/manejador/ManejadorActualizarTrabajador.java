package com.ceiba.portafolio.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.servicio.ServicioActualizarTrabajador;

import org.springframework.stereotype.Component;

import com.ceiba.portafolio.comando.ComandoTrabajador;
import com.ceiba.portafolio.comando.fabrica.FabricaTrabajador;

@Component
public class ManejadorActualizarTrabajador implements ManejadorComando<ComandoTrabajador> {

    private final FabricaTrabajador fabricaTrabajador;
    private final ServicioActualizarTrabajador servicioActualizarTrabajador;

    public ManejadorActualizarTrabajador(FabricaTrabajador fabricaTrabajador, ServicioActualizarTrabajador servicioActualizarTrabajador) {
        this.fabricaTrabajador = fabricaTrabajador;
        this.servicioActualizarTrabajador = servicioActualizarTrabajador;
    }

    public void ejecutar(ComandoTrabajador comandoTrabajador) {
        Trabajador trabajador = this.fabricaTrabajador.crear(comandoTrabajador);
        this.servicioActualizarTrabajador.ejecutar(trabajador);
    }


}
