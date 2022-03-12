
package com.ceiba.pago.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.fabrica.FabricaPago;
import com.ceiba.pago.modelo.dto.DtoPagoResponse;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.servicio.ServicioActualizarPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPago implements ManejadorComandoRespuesta<ComandoPago, DtoPagoResponse> {

        private final FabricaPago fabricaPago;
        private final ServicioActualizarPago servicioActualizarPago;

    public ManejadorActualizarPago(FabricaPago fabricaPago, ServicioActualizarPago servicioActualizarPago) {
        this.fabricaPago = fabricaPago;
        this.servicioActualizarPago = servicioActualizarPago;
    }
    public DtoPagoResponse ejecutar(ComandoPago comandoPago) {
        Pago pago = this.fabricaPago.crear(comandoPago);
        this.servicioActualizarPago.ejecutar(pago);
        return new DtoPagoResponse(pago.getId(), pago.getPlaca(), pago.getValorPago());
    }

}

