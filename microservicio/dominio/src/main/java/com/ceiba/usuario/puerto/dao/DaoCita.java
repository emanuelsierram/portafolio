package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoCita;

import java.util.List;

public interface DaoCita {


    List<DtoCita> listar();
    DtoCita listarPorId(Long id);

}
