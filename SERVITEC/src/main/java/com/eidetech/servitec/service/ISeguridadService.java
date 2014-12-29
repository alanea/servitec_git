/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service;

import com.eidetech.servitec.model.domain.entity.Personal;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface ISeguridadService {

    public boolean registrarNuevoPersonal(Personal personal);

    public boolean registrarNuevoUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public List<Personal> listaPersonas();

    public boolean registrarCliente(UsuarioCliente usuario);
    
    public boolean registrarTabla(TablaTipo tabla);
    
    public boolean registrarTipo(TablaTipo tipo);

    public boolean modificarTablaTipo(TablaTipo tablaTipo);
        
    public List<TablaTipo> obtenerTablaTipos();
}
