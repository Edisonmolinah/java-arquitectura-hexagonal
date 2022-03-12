package com.ceiba.pago.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPago {

        private Long id;
        private String placa;
        private Integer tipoVehiculo;
        private Float valorPago;
        private LocalDateTime fecha;

}
