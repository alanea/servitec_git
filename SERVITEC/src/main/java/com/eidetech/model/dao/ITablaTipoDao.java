/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.TablaTipo;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface ITablaTipoDao {

    public boolean agregarTabla(TablaTipo tabla);
    
    public boolean agregarTipo(TablaTipo tipo);
    
    public boolean agregarTodoTablaTipo(List<TablaTipo> lista) ;

    public boolean actualizarTablaTipo(TablaTipo tablaTipo);

    public List<TablaTipo> obtenerTodoTablaTipo();
}
