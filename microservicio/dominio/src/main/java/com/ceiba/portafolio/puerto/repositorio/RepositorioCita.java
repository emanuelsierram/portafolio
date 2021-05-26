package com.ceiba.portafolio.puerto.repositorio;

import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.entidad.Cita;


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
     * @param fechaInicio
     * @return si existe o no
     */
    boolean existe(LocalDateTime fechaInicio);

    /**
     * Permite actualizar un trabajador
     * @param cita
     */
    void actualizar(Cita cita);


    /**
     * Permite actualizar un trabajador
     * @param id
     */
    DtoCita listarPorId(Long id);


}
