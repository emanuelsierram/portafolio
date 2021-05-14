package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoCita;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String descripcion = resultSet.getString("descripcion");
        LocalDateTime fecha_inicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fecha_final = extraerLocalDateTime(resultSet, "fecha_final");
        Double valor = resultSet.getDouble("valor");
        String metodopago = resultSet.getString("metodopago");
        return new DtoCita(id,descripcion,fecha_inicio, fecha_final, valor, metodopago);

    }
}