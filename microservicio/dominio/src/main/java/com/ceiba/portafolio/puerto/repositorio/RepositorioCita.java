package com.ceiba.portafolio.puerto.repositorio;

import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.modelo.entidad.Cita;


import java.time.LocalDateTime;
import java.util.List;

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
     * Permite actualizar una cita
     * @param cita
     */
    void actualizar(Cita cita);


    /**
     * Permite buscar una cita por id
     * @param id
     */
    DtoCita listarPorId(Long id);

    /**
     * Permite eliminar una cita
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite listar citas por trabajador
     * @param id
     * @return las citas
     */
    List<DtoCita> listarPorIdTrabajador(Integer id);





}
