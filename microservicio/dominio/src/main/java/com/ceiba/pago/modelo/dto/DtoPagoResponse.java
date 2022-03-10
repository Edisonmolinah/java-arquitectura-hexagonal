package com.ceiba.pago.modelo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DtoPagoResponse {

    private Long id;
    private String placa;
    private Float pago;
    private String mensaje;


    public DtoPagoResponse(Long id, String placa, Float pago){

        this.id = id;
        this.placa = placa;
        this.pago = pago;
        this.mensaje = "El pago ha sido exitoso";

    }

}
