package com.ceiba.portafolio.puerto.dao;

import com.ceiba.portafolio.modelo.dto.DtoTrabajador;

import java.util.List;

public interface DaoTrabajador {

    /**
     * Permite listar trabajadores
     * @return los trabajadores
     */
    List<DtoTrabajador> listar();
}
