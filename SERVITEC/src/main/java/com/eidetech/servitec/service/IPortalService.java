/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.service;

import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.domain.entity.UbigeoDepartamento;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IPortalService {
    
    public List<TablaTipo> obtenerTablaTipos();
    
    public List<UbigeoDepartamento> obtenerUbigeos();
    
    public boolean registrarCliente(UsuarioCliente usuario);
}
