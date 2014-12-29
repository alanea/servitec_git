/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.service;

import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;

/**
 *
 * @author laptop-w8
 */
public interface IServicioTecnicoService {
    public boolean registrarNuevoReservacion(UsuarioCliente usuarioCliente,Reservacion reservacion);
}
