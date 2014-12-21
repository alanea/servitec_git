/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Personal;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface IPersonalDao{

    public  static final String PRE_PERSONAL = "PER";
    public boolean agregarPersonal(Personal personal) ;
    public boolean actualizarPersonal(Personal personal);

    public Personal obtenerPersonal(Personal personal);

    public List<Personal> obtenerTodoPersonal() ;
    
    public boolean agregarListaPersonal(List<Personal> lista);
}
