/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util.validator;

import com.eidetech.servitec.model.domain.entity.Persona;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.util.UtilCadena;

/**
 *
 * @author laptop-w8
 */
public class ValidatorCliente {

    public static boolean esClienteValido(UsuarioCliente usuario) {
        if (usuario != null && usuario.getPersona() != null) {
            Persona persona = usuario.getPersona();
            if (!UtilCadena.cadenaValido(persona.getId_persona())
                    || !UtilCadena.cadenaValido(persona.getDnombres())
                    || !UtilCadena.cadenaValido(persona.getDapellidoPaterno())
                    || !UtilCadena.cadenaValido(persona.getDapellidoMaterno())
                    || !UtilCadena.cadenaValido(persona.getDemail())
                    || !UtilCadena.cadenaValido(persona.getDsexo())) {
                return false;
            }

            if (!UtilCadena.cadenaValido(usuario.getDpassword())) {
                return false;
            }
            return true;
        }
        return false;
    }
}
