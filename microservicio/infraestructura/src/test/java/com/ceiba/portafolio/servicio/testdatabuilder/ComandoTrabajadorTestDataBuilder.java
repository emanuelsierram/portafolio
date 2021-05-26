package com.ceiba.portafolio.servicio.testdatabuilder;

import com.ceiba.portafolio.comando.ComandoTrabajador;
import java.util.UUID;

public class ComandoTrabajadorTestDataBuilder {

    private Long id;
    private String nombre;
    private String telefono;
    private String metodoPago;

    public ComandoTrabajadorTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        telefono = "1234";
        metodoPago = "crédito";
    }

    public ComandoTrabajadorTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoTrabajador build() {
        return new ComandoTrabajador(id,nombre, telefono,metodoPago);
    }
}
