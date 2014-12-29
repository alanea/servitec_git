/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util.validator;

import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilCadena;

/**
 *
 * @author laptop-w8
 */
public class ValidatorPersonal {

    public static boolean esValidoUsuarioPersonal(UsuarioPersonal usuario) {
        if (!UtilCadena.cadenaValido(usuario.getPersonal().getId_personal())) {
            return false;
        }
        if (!UtilCadena.cadenaValido(usuario.getDname())
                || !UtilCadena.cadenaValido(usuario.getDpassword())
                || !UtilCadena.cadenaValido(usuario.getDtipo())
                || !UtilCadena.cadenaValido(usuario.getDuserCreacion())) {
            return false;
        }
        return true;
    }
}
