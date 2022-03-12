package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.usuario.comando.ComandoUsuario;

import java.time.LocalDateTime;
import java.util.UUID;

public class ComandoPagoTestDataBuilder {

    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private Float pago;
    private LocalDateTime fechaPago;

    public ComandoPagoTestDataBuilder() {
        placa = "123abc";
        tipoVehiculo = 1;
        pago = 8000f;
        fechaPago = LocalDateTime.now();
    }

    public ComandoPagoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoPago build() {
        return new ComandoPago(id,placa, tipoVehiculo, pago,fechaPago);
    }
}













