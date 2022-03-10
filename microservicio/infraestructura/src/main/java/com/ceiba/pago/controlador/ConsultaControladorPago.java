package com.ceiba.pago.controlador;

import com.ceiba.pago.consulta.ManejadorListarpagos;
import com.ceiba.pago.modelo.dto.DtoPago;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagos")
@Api(tags={"Controlador consulta Pagos"})
public class ConsultaControladorPago {

    private final ManejadorListarpagos manejadorListarpagos;

    public ConsultaControladorPago(ManejadorListarpagos manejadorListarpagos) {
        this.manejadorListarpagos = manejadorListarpagos;
    }

    @GetMapping
    @ApiOperation("Listar Pagos")
    public List<DtoPago> listar() {
        return this.manejadorListarpagos.ejecutar();
    }

}
