package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Cita;

import java.time.LocalDateTime;

public interface RepositorioCita{
    /**
     * Permite crear una Cita
     * @param cita
     * @return el id generado
     */
    Long crear(Cita cita);

    /**
     * Permite actualizar un usuario
     * @param cita
     */
    void actualizar(Cita cita);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param fechaInicio
     * @return si existe o no
     */
    LocalDateTime consultar(LocalDateTime fechaInicio);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);



}
