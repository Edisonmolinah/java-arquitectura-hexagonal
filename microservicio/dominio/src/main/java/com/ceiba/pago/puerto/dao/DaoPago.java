package com.ceiba.pago.puerto.dao;

import com.ceiba.pago.modelo.dto.DtoPago;

import java.time.LocalDate;
import java.util.List;

public interface DaoPago {

    List<DtoPago> listar(LocalDate fecha);
}
