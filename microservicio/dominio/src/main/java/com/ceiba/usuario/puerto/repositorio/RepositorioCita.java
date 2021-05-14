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
     * Permite validar si existe una cita con un descripcion
     * @param descripcion
     * @return si existe o no
     */
    boolean existe(String descripcion);





}
