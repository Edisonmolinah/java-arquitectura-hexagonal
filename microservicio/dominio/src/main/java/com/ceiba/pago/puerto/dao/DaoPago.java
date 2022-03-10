package com.ceiba.pago.puerto.dao;

import com.ceiba.pago.modelo.dto.DtoPago;
import com.ceiba.pago.modelo.dto.DtoPagoResponse;

import java.util.List;

public interface DaoPago {

    List<DtoPago> listar();
}
