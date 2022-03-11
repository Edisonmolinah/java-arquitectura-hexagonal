package com.ceiba.pago.puerto.repositorio;

import com.ceiba.pago.modelo.entidad.Pago;

public interface RepositorioPago {

    /**
     * Permite crear un usuario
     * @param pago
     * @return el id generado
     */
    Long crear(Pago pago);

    /**
     * Permite actualizar un usuario
     * @param pago
     */
    void actualizar(Pago pago);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param placa
     * @return si existe o no
     */
    boolean existe(String placa);


}
