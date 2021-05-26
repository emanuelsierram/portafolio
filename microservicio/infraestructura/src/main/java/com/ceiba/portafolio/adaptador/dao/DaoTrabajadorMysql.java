package com.ceiba.portafolio.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.portafolio.puerto.dao.DaoTrabajador;

import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import org.springframework.stereotype.Component;


@Component
public class DaoTrabajadorMysql implements DaoTrabajador {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="trabajador", value="listar")
    private static String sqlListar;

    public DaoTrabajadorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoTrabajador> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoTrabajador());
    }
}
