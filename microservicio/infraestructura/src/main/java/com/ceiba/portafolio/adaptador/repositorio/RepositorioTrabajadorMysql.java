package com.ceiba.portafolio.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import com.ceiba.portafolio.modelo.entidad.Trabajador;
import com.ceiba.portafolio.puerto.repositorio.RepositorioTrabajador;
import com.ceiba.portafolio.adaptador.dao.MapeoTrabajador;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTrabajadorMysql implements RepositorioTrabajador {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="trabajador", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="trabajador", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="trabajador", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="trabajador", value="existeExcluyendoId")
    private static String sqlExisteExcluyendoId;


    @SqlStatement(namespace = "trabajador", value = "listarPorId")
    private static  String sqlListarPorId;

    public RepositorioTrabajadorMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Trabajador trabajador) {
        return this.customNamedParameterJdbcTemplate.crear(trabajador, sqlCrear);
    }


    @Override
    public boolean existe(String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Trabajador trabajador) {
        this.customNamedParameterJdbcTemplate.actualizar(trabajador, sqlActualizar);
    }

    @Override
    public boolean existeExcluyendoId(Long id, String nombre) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        paramSource.addValue("nombre", nombre);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteExcluyendoId,paramSource, Boolean.class);
    }

    @Override
    public DtoTrabajador listarPorId(Integer id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlListarPorId, paramSource, new MapeoTrabajador());
    }

}
