package com.ceiba.pago.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.pago.puerto.dao.DaoPago;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DaoPagoMysql implements DaoPago {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pago", value="listarPago")
    private static String sqlListar;

    public DaoPagoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoPago> listar(LocalDate fecha) {
        Map<String, LocalDate> parameters = new HashMap<String, LocalDate>();
        parameters.put("fecha", fecha);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, parameters, new MapeoPago());
    }


}
