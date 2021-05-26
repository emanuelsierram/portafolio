package com.ceiba.portafolio.servicio;

import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;

public class ServicioEliminarTrabajador {

    private final RepositorioTrabajador repositorioTrabajador;

    public ServicioEliminarTrabajador(RepositorioTrabajador repositorioTrabajador) {
        this.repositorioTrabajador = repositorioTrabajador;
    }

    public void ejecutar(Long id) {
        this.repositorioTrabajador.eliminar(id);
    }
}
