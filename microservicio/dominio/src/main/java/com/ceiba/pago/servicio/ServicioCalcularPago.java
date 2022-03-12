package com.ceiba.pago.servicio;

import com.ceiba.pago.modelo.dto.DtoCalcularPago;
import com.ceiba.pago.modelo.dto.DtoPago;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ServicioCalcularPago {

    public DtoCalcularPago ejecutar(Integer tipoVehiculo ) throws Exception {
        calcularValorPago(tipoVehiculo);
        DtoPago dtoPago = new DtoPago();
        dtoPago.setTipoVehiculo(dtoPago.getTipoVehiculo());
        dtoPago.setFechaPago(dtoPago.getFechaPago());


        return new DtoCalcularPago(tipoVehiculo, calcularValorPago(tipoVehiculo));
    }

    private Float calcularValorPago(Integer tipoVehiculo) throws Exception {

        float tarifaVehiculo = 0;
        LocalDate fechaCobro = LocalDate.now();
        switch (tipoVehiculo) {
            case 1:
                tarifaVehiculo = 8000;
                break;
            case 2:
                tarifaVehiculo = 12000;
                break;
            case 3:
                tarifaVehiculo = 18000;
                break;

            default:
                throw new Exception("El tipo de vehiculo es incorrecto");


        }

        if (fechaCobro.getDayOfWeek().getValue() == DayOfWeek.SATURDAY.getValue()
                || fechaCobro.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue()) {

            tarifaVehiculo = tarifaVehiculo * 1.15f;


        }
        return tarifaVehiculo;
    }
}

