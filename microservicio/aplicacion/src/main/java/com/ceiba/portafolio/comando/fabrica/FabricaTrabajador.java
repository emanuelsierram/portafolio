package com.ceiba.portafolio.comando.fabrica;

import com.ceiba.portafolio.modelo.entidad.Trabajador;
import org.springframework.stereotype.Component;

import com.ceiba.portafolio.comando.ComandoTrabajador;

@Component
public class FabricaTrabajador {

    public Trabajador crear(ComandoTrabajador comandoTrabajador) {
        return new Trabajador(
                comandoTrabajador.getId(),
                comandoTrabajador.getNombre(),
                comandoTrabajador.getTelefono(),
                comandoTrabajador.getMetodoPago()
        );
    }

}
