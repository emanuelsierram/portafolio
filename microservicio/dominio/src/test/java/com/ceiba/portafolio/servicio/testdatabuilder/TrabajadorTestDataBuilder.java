package com.ceiba.portafolio.servicio.testdatabuilder;
import com.ceiba.portafolio.modelo.entidad.Trabajador;

public class TrabajadorTestDataBuilder {

    private Long id;
    private String nombre;
    private String telefono;
    private String metodoPago;

    public TrabajadorTestDataBuilder() {
        nombre = "Ema";
        telefono = "3017768234";
        metodoPago = "Crédito";
    }

    public TrabajadorTestDataBuilder conTelefono(String clave) {
        this.telefono = telefono;
        return this;
    }

    public TrabajadorTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Trabajador build() {
        return new Trabajador(id,nombre, telefono,metodoPago);
    }
}
