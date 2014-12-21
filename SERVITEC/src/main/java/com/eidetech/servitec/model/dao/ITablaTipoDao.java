/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.TablaTipo;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface ITablaTipoDao {

    public boolean agregarTablaTipo(TablaTipo tablaTipo) ;

    public boolean agregarTodoTablaTipo(List<TablaTipo> lista) ;

    public boolean actualizarTablaTipo(TablaTipo tablaTipo);

    public List<TablaTipo> obtenerTodoTablaTipo();
}