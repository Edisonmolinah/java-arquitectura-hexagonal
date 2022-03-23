package com.ceiba.pago.entidad;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PagoTest {

    @Test
    @DisplayName("Deberia crear correctamente el Pago")
    void deberiaCrearCorrectamenteElPago() {
        // arrange
        LocalDateTime fechaCreacion = LocalDateTime.now();
        //act
        Pago pago = new PagoTestDataBuilder().conFechaPago(fechaCreacion).conId(1L).build();

        //assert
        assertEquals(1, pago.getId());
        assertEquals("abc123", pago.getPlaca());
        assertEquals(1, pago.getTipoVehiculo());
        assertEquals(fechaCreacion, pago.getFechaPago());
    }

    @Test
    void deberiaFallarSinPlaca() {

        //Arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conPlaca(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la placa de 6 caracteres");
    }

    @Test
    void deberiaFallarSinTipoVehiculo() {

        //Arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conTipoVehiculo(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "El tipo de vehiculo debe ser entre 1 - 3");
    }

    @Test
    void deberiaFallarSinFechaCreacion() {

        //Arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conFechaPago(null).conId(1L);
        //act-assert
        BasePrueba.assertThrows(() -> {
                    pagoTestDataBuilder.build();
                },
                ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de Pago");
    }
}
