package com.ceiba.pago.adaptador.dao;

import com.ceiba.pago.modelo.dto.DtoPago;
import org.springframework.jdbc.core.RowMapper;
import com.ceiba.infraestructura.jdbc.MapperResult;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoPago implements RowMapper<DtoPago>, MapperResult {
    @Override
    public DtoPago mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String placa = resultSet.getString("placa");
        Integer tipoVehiculo = resultSet.getInt("tipo_vehiculo");
        Float valorPago = resultSet.getFloat("valor_pago");
        LocalDateTime fechaPago = extraerLocalDateTime(resultSet, "fecha_pago");

        return new DtoPago(id, placa, tipoVehiculo, valorPago, fechaPago);
    }
}
