update pago
set placa = :placa,
    tipo_vehiculo = :tipoVehiculo,
    valor_pago = :valorPago,
    fecha_pago = :fechaPago
where id = :id