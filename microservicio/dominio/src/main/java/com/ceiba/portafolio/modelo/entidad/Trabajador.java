package com.ceiba.portafolio.modelo.entidad;


import lombok.Getter;
import lombok.Setter;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Setter
public class Trabajador {

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_TRABAJADOR = "Se debe ingresar el nombre del trabajador";
    private static final String SE_DEBE_INGRESAR_EL_METODO_DE_PAGO = "Se debe ingresar el nombre del trabajador";

    private Long id;
    private String nombre;
    private String telefono;
    private String metodoPago;

    public Trabajador(Long id, String nombre, String telefono, String metodoDePago) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_TRABAJADOR);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);
        validarObligatorio(metodoDePago, SE_DEBE_INGRESAR_EL_METODO_DE_PAGO);
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.metodoPago = metodoDePago;

    }

}
