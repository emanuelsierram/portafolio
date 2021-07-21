package com.ceiba.portafolio.puerto.dao;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import java.util.List;

public interface DaoCita {
    /**
     * Permite listar citas por trabajador
     * @param id
     * @return las citas
     */
    List<DtoCita> listarPorId(Integer id);

    /**
     * Permite listar citas por id
     * @return una cita
     */
    DtoCita obtenerCita(Long id);


}
