package com.ceiba.portafolio.servicio;


import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;


public class ServicioCrearTrabajador {

    private static final String EL_TRABAJADOR_YA_EXISTE_EN_EL_SISTEMA = "El trabajador ya existe en el sistema";

    private final RepositorioTrabajador repositorioTrabajador;

    public ServicioCrearTrabajador(RepositorioTrabajador repositorioTrabajador) {
        this.repositorioTrabajador = repositorioTrabajador;
    }

    public Long ejecutar(Trabajador trabajador) {
        validarExistenciaPrevia(trabajador);

        return this.repositorioTrabajador.crear(trabajador);
    }

    private void validarExistenciaPrevia(Trabajador trabajador) {
        boolean existe = this.repositorioTrabajador.existe(trabajador.getNombre());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_TRABAJADOR_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
