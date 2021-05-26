package com.ceiba.portafolio.consulta;

import java.util.List;

import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.puerto.dao.DaoTrabajador;
import org.springframework.stereotype.Component;


@Component
public class ManejadorListarTrabajador {

    private final DaoTrabajador daoTrabajador;

    public ManejadorListarTrabajador(DaoTrabajador daoTrabajador){
        this.daoTrabajador = daoTrabajador;
    }

    public List<DtoTrabajador> ejecutar(){ return this.daoTrabajador.listar(); }
}
