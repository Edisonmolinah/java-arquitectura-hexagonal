package com.ceiba.pago.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;

public class ServicioActualizarPago {

    private static final String EL_PAGO_NO_EXISTE_EN_EL_SISTEMA = "El no pago existe en el sistema";

    private final RepositorioPago repositorioPago;

    public ServicioActualizarPago(RepositorioPago repositorioPago) {
        this.repositorioPago = repositorioPago;
    }

    public void ejecutar(Pago pago) {
        validarExistenciaPrevia(pago);
        this.repositorioPago.actualizar(pago);
    }

    private void validarExistenciaPrevia(Pago pago) {
        boolean existe = this.repositorioPago.existePorId(pago.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_PAGO_NO_EXISTE_EN_EL_SISTEMA);
        }

    }

}



