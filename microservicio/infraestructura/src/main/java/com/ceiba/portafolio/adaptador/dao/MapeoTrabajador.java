package com.ceiba.portafolio.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.portafolio.modelo.dto.DtoTrabajador;
import org.springframework.jdbc.core.RowMapper;

public class MapeoTrabajador implements RowMapper<DtoTrabajador>, MapperResult {

    @Override
    public DtoTrabajador mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String telefono = resultSet.getString("telefono");
        String metodoPago = resultSet.getString("metodo_pago");
        return new DtoTrabajador(id,nombre,telefono, metodoPago);
    }

}
