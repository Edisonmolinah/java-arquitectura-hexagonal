package com.ceiba.pago.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;
import com.ceiba.pago.servicio.testdatabuilder.PagoTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioActualizarPagoTest {

    @Test
    @DisplayName("Deberia validar la existencia previa del usuario")
    void deberiaValidarLaExistenciaPreviaDelPago() {
        // arrange
        Pago pago = new PagoTestDataBuilder().conId(1L).build();
        RepositorioPago repositorioPago = Mockito.mock(RepositorioPago.class);
        Mockito.when(repositorioPago.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarPago servicioActualizarPago = new ServicioActualizarPago(repositorioPago);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarPago.ejecutar(pago), ExcepcionDuplicidad.class,"El no pago existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Pago pago = new PagoTestDataBuilder().conId(1L).build();
        RepositorioPago repositorioPago = Mockito.mock(RepositorioPago.class);
        Mockito.when(repositorioPago.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarPago servicioActualizarPago = new ServicioActualizarPago(repositorioPago);
        // act
        servicioActualizarPago.ejecutar(pago);
        //assert
        Mockito.verify(repositorioPago,Mockito.times(1)).actualizar(pago);
    }
}
