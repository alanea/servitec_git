/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.util.validator;

import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.util.UtilCadena;

/**
 *
 * @author usuario-xp
 */
public class ValidatorSede {

    public static boolean esValidoSede(Sede sede) {
        if (sede != null) {
            return UtilCadena.cadenaValido(sede.getDnombre());
        }
        return false;
    }

    public static Sede validarSede(Sede sede) {

        return sede;
    }
}
