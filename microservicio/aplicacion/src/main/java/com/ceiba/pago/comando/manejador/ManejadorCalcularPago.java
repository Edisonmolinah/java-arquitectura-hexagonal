package com.ceiba.pago.comando.manejador;

import com.ceiba.pago.modelo.dto.DtoCalcularPago;
import com.ceiba.pago.servicio.ServicioCalcularPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCalcularPago {

    private final ServicioCalcularPago servicioCalcularPago;

    public ManejadorCalcularPago(ServicioCalcularPago servicioCalcularPago) {
        this.servicioCalcularPago = servicioCalcularPago;
    }

    public DtoCalcularPago ejecutar(Integer tipoVehiculo) {
      return this.servicioCalcularPago.ejecutar(tipoVehiculo);
    }
}
