/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.util.validator;

import com.eidetech.servitec.model.domain.entity.Producto;
import com.eidetech.servitec.model.util.UtilNumero;


/**
 *
 * @author usuario-xp
 */
public class ValidatorProducto {
    public static Producto validarProducto(Producto p){
        p.setDdescripcion(p.getDdescripcion().toUpperCase());
        p.setDestado(p.getDestado().toUpperCase());
        p.setDmoneda(p.getDmoneda().toUpperCase());
        p.setDtesp(p.getDtesp().toUpperCase());
        p.setMprecio(UtilNumero.redondear(p.getMprecio(), 2));
        return p;
    }
}
