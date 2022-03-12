package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.pago.comando.ComandoPago;

import java.time.LocalDateTime;

public class ComandoPagoTestDataBuilder {

    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private Float valorPago;
    private LocalDateTime fechaPago;

    public ComandoPagoTestDataBuilder() {
        placa = "123abc";
        tipoVehiculo = 1;
        valorPago = 8000f;
        fechaPago = LocalDateTime.now();
    }

    public ComandoPagoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public ComandoPago build() {
        return new ComandoPago(id,placa, tipoVehiculo, valorPago,fechaPago);
    }
}













