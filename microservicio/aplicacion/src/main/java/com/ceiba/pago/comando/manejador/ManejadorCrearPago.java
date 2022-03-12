package com.ceiba.pago.comando.manejador;


import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.fabrica.FabricaPago;
import com.ceiba.pago.modelo.dto.DtoPagoResponse;
import com.ceiba.pago.modelo.entidad.Pago;
import com.ceiba.pago.servicio.ServicioCrearPago;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPago  {

    private final FabricaPago fabricaPago;
    private final ServicioCrearPago servicioCrearPago;

    public ManejadorCrearPago(FabricaPago fabricaPago, ServicioCrearPago servicioCrearPago) {
        this.fabricaPago = fabricaPago;
        this.servicioCrearPago = servicioCrearPago;
    }

    public DtoPagoResponse ejecutar(ComandoPago comandoPago) {
        Pago pago = this.fabricaPago.crear(comandoPago);
        Long id = this.servicioCrearPago.ejecutar(pago);
        return new DtoPagoResponse(id, pago.getPlaca(), pago.getValorPago());
    }



}
