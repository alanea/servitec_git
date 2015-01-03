/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Sede;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface ISedeDao{
    
    public boolean agregarSede(Sede sede);
    
    public boolean actualizarSede(Sede sede);
    
    public Sede obtenerSede(Sede sede) ;
    
    public List<Sede> obtenerListaSedes();
    
    public boolean agregarListaSede(List<Sede> sedes);    
}
