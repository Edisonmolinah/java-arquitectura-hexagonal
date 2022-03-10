
package com.ceiba.pago.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class DtoPago {
    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private Float pago;
    private LocalDateTime fechaPago;

    public DtoPago() {

    }
}

