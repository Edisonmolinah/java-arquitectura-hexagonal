package com.ceiba.pago.servicio.testdatabuilder;

import com.ceiba.pago.modelo.entidad.Pago;
import java.time.LocalDateTime;


public class PagoTestDataBuilder {

    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private Float pago;
    private LocalDateTime fechaPago;

   public PagoTestDataBuilder() {


        placa = "abc123";
        tipoVehiculo = 1;
        fechaPago = LocalDateTime.now();
    }

    public PagoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }


    public PagoTestDataBuilder conPlaca(String placa) {
        this.placa = placa;
        return this;
    }

    public PagoTestDataBuilder conTipoVehiculo(Integer tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
        return this;
    }

    public PagoTestDataBuilder conPago(Float pago) {
        this.pago = pago;
        return this;
    }

    public PagoTestDataBuilder conFechaPago(LocalDateTime fechaCreacion) {
        this.fechaPago = fechaCreacion;
        return this;
    }

    public Pago build() {
        return new Pago(id,placa, tipoVehiculo, pago,fechaPago);
    }


}
