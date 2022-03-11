package com.ceiba.pago.modelo.entidad;

import lombok.Getter;

import java.time.LocalDateTime;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Pago {

    private static final String SE_DEBE_INGRESAR_LA_PLACA = "Se debe ingresar la placa de 6 caracteres";
    private static final String LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A = "La placa debe tener una longitud igual a %s";
    private static final String SE_DEBE_INGRESAR_EL_TIPO_VEHICULO = "El tipo de vehiculo debe ser entre 1 - 3";
    private static final String SE_DEBE_INGRESAR_LA_FECHA_PAGO = "Se debe ingresar la fecha de Pago";

    private static final int LONGITUD_PLACA = 6;

    private Long id;
    private String placa;
    private Integer tipoVehiculo;
    private Float pago;
    private LocalDateTime fechaPago;

    public Pago(Long id,String placa, Integer tipoVehiculo, Float pago, LocalDateTime fechaPago) {
        validarObligatorio(placa, SE_DEBE_INGRESAR_LA_PLACA);
        validarLongitud(placa, LONGITUD_PLACA, String.format(LA_PLACA_DEBE_TENER_UNA_LONGITUD_IGUAL_A,LONGITUD_PLACA));
        validarObligatorio(tipoVehiculo, SE_DEBE_INGRESAR_EL_TIPO_VEHICULO);
        validarObligatorio(fechaPago, SE_DEBE_INGRESAR_LA_FECHA_PAGO);

        this.id = id;
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.pago = pago;
        this.fechaPago = fechaPago;
    }
}
