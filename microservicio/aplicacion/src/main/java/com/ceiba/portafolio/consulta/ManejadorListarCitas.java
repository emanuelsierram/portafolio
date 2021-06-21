package com.ceiba.portafolio.consulta;

import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.puerto.dao.DaoCita;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCitas {

    private final DaoCita daoCita;

    public ManejadorListarCitas(DaoCita daoCita){
        this.daoCita = daoCita;
    }

    public List<DtoCita> ejecutar(Integer id){ return this.daoCita.listarPorId(id); }
}
