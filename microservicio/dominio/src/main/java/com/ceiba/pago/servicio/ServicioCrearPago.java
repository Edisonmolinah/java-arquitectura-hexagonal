package com.ceiba.pago.servicio;


import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.puerto.repositorio.RepositorioPago;


public class ServicioCrearPago {


    private final RepositorioPago repositorioPago;

    public ServicioCrearPago(RepositorioPago repositorioPago) {

        this.repositorioPago = repositorioPago;
    }


    public Long ejecutar(Pago pago) {
       return this.repositorioPago.crear(pago);
    }

}
