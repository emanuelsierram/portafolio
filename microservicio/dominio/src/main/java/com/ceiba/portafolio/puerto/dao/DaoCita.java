package com.ceiba.portafolio.puerto.dao;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import java.util.List;

public interface DaoCita {
    List<DtoCita> listarPorId(Integer id);
    DtoCita obtenerCita(Integer idTrabajador, Long id);


}
