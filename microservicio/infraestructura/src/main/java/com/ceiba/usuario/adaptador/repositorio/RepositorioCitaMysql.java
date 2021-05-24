package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Cita;
import com.ceiba.usuario.puerto.repositorio.RepositorioCita;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public class RepositorioCitaMysql implements RepositorioCita {
    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;



    @SqlStatement(namespace="cita", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="cita", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="cita", value="actualizar")
    private static String sqlActualizar;

    public RepositorioCitaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }
    @Override
    public Long crear(Cita cita) { return this.customNamedParameterJdbcTemplate.crear(cita, sqlCrear); }

    @Override
    public void actualizar(Cita cita) {

        this.customNamedParameterJdbcTemplate.actualizar(cita, sqlActualizar);
    }


    @Override
    public boolean existe(LocalDateTime fecha) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha_inicio", fecha);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }





}
