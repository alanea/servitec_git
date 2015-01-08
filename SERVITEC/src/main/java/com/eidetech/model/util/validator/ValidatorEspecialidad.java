/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.util.validator;

import com.eidetech.model.domain.entity.Categoria;


/**
 *
 * @author usuario-xp
 */
public class ValidatorEspecialidad {

    public static Categoria validarEspecialidad(Categoria especialidad) {
        especialidad.setDnombre(especialidad.getDnombre().toUpperCase());
        especialidad.setDdescripcion(especialidad.getDdescripcion().toUpperCase());
        especialidad.setDgrupo(especialidad.getDgrupo().toUpperCase());
        return especialidad;
    }
}
