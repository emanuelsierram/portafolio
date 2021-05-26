package com.ceiba.portafolio.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;


public class ServicioCrearTrabajador {

    private static final String EL_trabajador_YA_EXISTE_EN_EL_SISTEMA = "El trabajador ya existe en el sistema";

    private final RepositorioTrabajador repositoriotrabajador;

    public ServicioCrearTrabajador(RepositorioTrabajador repositoriotrabajador) {
        this.repositoriotrabajador = repositoriotrabajador;
    }

    public Long ejecutar(Trabajador trabajador) {
        validarExistenciaPrevia(trabajador);

        return this.repositoriotrabajador.crear(trabajador);
    }

    private void validarExistenciaPrevia(Trabajador trabajador) {
        boolean existe = this.repositoriotrabajador.existe(trabajador.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_trabajador_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
