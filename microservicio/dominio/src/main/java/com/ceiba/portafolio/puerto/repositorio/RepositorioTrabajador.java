package com.ceiba.portafolio.puerto.repositorio;

import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.modelo.entidad.Trabajador;

public interface RepositorioTrabajador {
    /**
     * Permite crear un trabajador
     * @param trabajador
     * @return el id generado
     */
    Long crear(Trabajador trabajador);

    /**
     * Permite actualizar un trabajador
     * @param trabajador
     */
    void actualizar(Trabajador trabajador);

    /**
     * Permite eliminar un trabajador
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un trabajador con un nombre
     * @param nombre
     * @return si existe o no
     */
    boolean existe(String nombre);

    /**
     * Permite validar si existe un trabajador con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);


    /**
     * Permite actualizar un trabajador
     * @param id
     */
    DtoTrabajador listarPorId(Integer id);



}
