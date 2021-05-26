package com.ceiba.portafolio.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;


public class ServicioActualizarTrabajador {

    private static final String EL_TRABAJADOR_YA_EXISTE_EN_EL_SISTEMA = "El trabajador ya existe en el sistema";

    private final RepositorioTrabajador repositorioTrabajador;

    public ServicioActualizarTrabajador(RepositorioTrabajador repositorioTrabajador) {
        this.repositorioTrabajador = repositorioTrabajador;
    }

    public void ejecutar(Trabajador trabajador) {
        validarExistenciaPrevia(trabajador);
        this.repositorioTrabajador.actualizar(trabajador);
    }

    private void validarExistenciaPrevia(Trabajador trabajador) {
        boolean existe = this.repositorioTrabajador.existeExcluyendoId(trabajador.getId(),trabajador.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TRABAJADOR_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
