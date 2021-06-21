package com.ceiba.portafolio.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.portafolio.modelo.dto.DtoCita;
import com.ceiba.portafolio.puerto.dao.DaoCita;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCitaMysql implements DaoCita {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="cita", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace = "cita", value = "listarPorIdTrabajador")
    private static  String sqlListarPorIdTrabajador;


    public DaoCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCita> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCita());
    }

    @Override
    public List<DtoCita> listarPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_trabajador", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorIdTrabajador, paramSource, new MapeoCita());
    }





}
