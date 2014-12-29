/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util.validator;

import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.util.UtilCadena;
import com.eidetech.servitec.model.util.UtilFecha;

/**
 *
 * @author laptop-w8
 */
public class ValidatorReservacion {

    public static boolean esValidoReservacion(Reservacion reservacion) {
        if (reservacion != null) {
            if (!UtilCadena.cadenaValido(reservacion.getDcategoria_producto())
                    || !UtilCadena.cadenaValido(reservacion.getDproducto())
                    || !UtilCadena.cadenaValido(reservacion.getDproblema())
                    ||!UtilFecha.fechaValido(reservacion.getFfecha())) {
                return false;
            }
            return true;
        }
        return false;
    }
}
