package com.ceiba.pago.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPagoMysql implements RepositorioPago {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pago", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="pago", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="pago", value="existePorId")
    private static String sqlExistePorId;

    /*@SqlStatement(namespace="pago", value="eliminar")
    private static String sqlEliminar;*/


    public RepositorioPagoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Pago pago) {
        this.customNamedParameterJdbcTemplate.crear(pago, sqlCrear);
        return null;
    }



    @Override
    public void actualizar(Pago pago) {
        //this.customNamedParameterJdbcTemplate.actualizar(pago, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId, paramSource, Boolean.class);
    }
}
