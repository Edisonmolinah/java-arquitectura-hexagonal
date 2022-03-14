package com.ceiba.pago.controlador;

import com.ceiba.pago.comando.ComandoPago;
import com.ceiba.pago.comando.manejador.ManejadorActualizarPago;
import com.ceiba.pago.comando.manejador.ManejadorCalcularPago;
import com.ceiba.pago.comando.manejador.ManejadorCrearPago;
import com.ceiba.pago.modelo.dto.DtoCalcularPago;
import com.ceiba.pago.modelo.dto.DtoPagoResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pago")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorPago {

    private final ManejadorCrearPago manejadorCrearPago;
    private final ManejadorActualizarPago manejadorActualizarPago;
    private final ManejadorCalcularPago manejadorCalcularPago;

    @Autowired
    public ComandoControladorPago(ManejadorCrearPago manejadorCrearPago,
                                  ManejadorActualizarPago manejadorActualizarPago, ManejadorCalcularPago manejadorCalcularPago) {
        this.manejadorCrearPago = manejadorCrearPago;
        this.manejadorActualizarPago = manejadorActualizarPago;
        this.manejadorCalcularPago = manejadorCalcularPago;
    }

    @PostMapping
    @ApiOperation("Crear Pago")
    public DtoPagoResponse crear(@RequestBody ComandoPago comandoPago) {
         return manejadorCrearPago.ejecutar(comandoPago);
    }
    @GetMapping("/calcular_pago/{tipoVehiculo}")
    @ApiOperation("Calcular Pago")
    public DtoCalcularPago calcularPago(@PathVariable Integer tipoVehiculo) {
        return manejadorCalcularPago.ejecutar(tipoVehiculo);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Pago")
    public DtoPagoResponse actualizar(@RequestBody ComandoPago comandoPago,@PathVariable Long id) {
        comandoPago.setId(id);
       return manejadorActualizarPago.ejecutar(comandoPago);
    }
}
