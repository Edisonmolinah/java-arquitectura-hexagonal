package com.ceiba.pago.servicio;


import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ServicioCrearPagoTest {

    @Test
    @DisplayName("Deberia lanzar una exepecion cuando la longitud de la Placa sea menor a 6")
    void deberiaLanzarUnaExepcionCuandoLaLongitudDeLaPlacaSeaMenorASeis() {
        // arrange
        PagoTestDataBuilder pagoTestDataBuilder = new PagoTestDataBuilder().conPlaca("ab12");
        // act - assert
        BasePrueba.assertThrows(pagoTestDataBuilder::build, ExcepcionLongitudValor.class, "La placa debe tener una longitud igual a 6");
    }

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del Pago")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelPago() {
        // arrange
        Pago pago = new PagoTestDataBuilder().build();
        RepositorioPago repositorioPago = Mockito.mock(RepositorioPago.class);
        Mockito.when(repositorioPago.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearPago servicioCrearPago = new ServicioCrearPago(repositorioPago);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearPago.ejecutar(pago), ExcepcionDuplicidad.class,"El pago ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear el usuario de manera correcta")
    void deberiaCrearElPagoDeManeraCorrecta() {
        // arrange
        Pago pago = new PagoTestDataBuilder().build();
        RepositorioPago repositorioPago = Mockito.mock(RepositorioPago.class);
        Mockito.when(repositorioPago.existe(Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioPago.crear(pago)).thenReturn(10L);
        ServicioCrearPago servicioCrearPago = new ServicioCrearPago(repositorioPago);
        // act
        Long idPago = servicioCrearPago.ejecutar(pago);
        //- assert
        assertEquals(10L,idPago);
        Mockito.verify(repositorioPago, Mockito.times(1)).crear(pago);
    }
}
