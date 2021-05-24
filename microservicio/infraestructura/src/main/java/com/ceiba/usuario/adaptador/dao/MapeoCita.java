package com.ceiba.usuario.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoCita;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoCita implements RowMapper<DtoCita>, MapperResult {

    @Override
    public DtoCita mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Long id = resultSet.getLong("id");
        String descripcion = resultSet.getString("descripcion");
        LocalDateTime fechaInicio = extraerLocalDateTime(resultSet, "fecha_inicio");
        LocalDateTime fechaFinal = extraerLocalDateTime(resultSet, "fecha_final");
        Double valor = resultSet.getDouble("valor");
        String metodoPago = resultSet.getString("metodo_pago");
        return new DtoCita(id,descripcion,fechaInicio, fechaFinal, valor, metodoPago);

    }
}