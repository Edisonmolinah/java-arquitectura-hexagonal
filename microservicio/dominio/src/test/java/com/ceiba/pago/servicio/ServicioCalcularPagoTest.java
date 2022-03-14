package com.ceiba.pago.servicio;

import com.ceiba.pago.modelo.dto.DtoCalcularPago;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ServicioCalcularPagoTest {

    @Test
    @DisplayName(" Se valida el calculo del pago")
    void calcularPagoTest1() throws Exception {

        ServicioCalcularPago servicioCalcularPago = new ServicioCalcularPago();
        DtoCalcularPago dtoCalcularPago = servicioCalcularPago.ejecutar(1);
        if (validarDiaPago()){
            assertEquals(8000*1.15f, dtoCalcularPago.getValorAPagar());
            assertEquals(1, dtoCalcularPago.getTipoVehiculo());
        }else
        assertEquals(8000, dtoCalcularPago.getValorAPagar());
        assertEquals(1, dtoCalcularPago.getTipoVehiculo());
    }

    @Test
    @DisplayName(" Se valida el calculo del pago")
    void calcularPagoTest2() throws Exception {


        ServicioCalcularPago servicioCalcularPago = new ServicioCalcularPago();
        DtoCalcularPago dtoCalcularPago = servicioCalcularPago.ejecutar(2);

        if (validarDiaPago()){
            assertEquals(12000*1.15f, dtoCalcularPago.getValorAPagar());
            assertEquals(2, dtoCalcularPago.getTipoVehiculo());
        }else
            assertEquals(12000, dtoCalcularPago.getValorAPagar());
        assertEquals(2, dtoCalcularPago.getTipoVehiculo());
    }

    @Test
    @DisplayName(" Se valida el calculo del pago")
    void calcularPagoTest3() throws Exception {

        ServicioCalcularPago servicioCalcularPago = new ServicioCalcularPago();
        DtoCalcularPago dtoCalcularPago = servicioCalcularPago.ejecutar(3);

        if (validarDiaPago()){
            assertEquals(18000*1.15f, dtoCalcularPago.getValorAPagar());
            assertEquals(3, dtoCalcularPago.getTipoVehiculo());
        }else
            assertEquals(18000, dtoCalcularPago.getValorAPagar());
        assertEquals(3, dtoCalcularPago.getTipoVehiculo());
    }

    @Test
    @DisplayName(" Se valida el calculo del pago")
    void calcularPagoTestExcepcion() throws Exception {

        ServicioCalcularPago servicioCalcularPago = new ServicioCalcularPago();
        assertThrows(Exception.class, () -> servicioCalcularPago.ejecutar(4));

    }

    private Boolean validarDiaPago() {
        LocalDate fechaCobro = LocalDate.now();
        if (fechaCobro.getDayOfWeek().getValue() == DayOfWeek.SATURDAY.getValue()
                || fechaCobro.getDayOfWeek().getValue() == DayOfWeek.SUNDAY.getValue()) {

           return true;
        }
        return false;
    }
}
