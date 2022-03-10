package com.ceiba.pago.modelo.entidad;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
@Builder
public class Pago {

    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_VEHICULO = "El tipo de vehiculo debe ser entre 1 - 3";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_PAGO = "Se debe ingresar la fecha de Pago";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private Float pago;
    private LocalDateTime fechaPago;

    public Pago(Long id,String placa, Integer tipoVehiculo, Float pago, LocalDateTime fechaPago) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarObligatorio(tipoVehiculo, SE_DEBE_INGRESAR_EL_TIPO_VEHICULO);
        validarObligatorio(fechaPago, SE_DEBE_INGRESAR_LA_FECHA_PAGO);

        this.id = id;
        this.placa = placa;
        this.pago = pago;
        this.tipoVehiculo = tipoVehiculo;
        this.fechaPago = fechaPago;
    }
}
