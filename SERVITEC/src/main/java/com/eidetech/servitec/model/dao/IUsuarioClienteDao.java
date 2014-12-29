/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.UsuarioCliente;

/**
 *
 * @author laptop-w8
 */
public interface IUsuarioClienteDao {
 
    public static final String PRE_USUARIO = "USR";
    
    public boolean agregarUsuarioCliente(UsuarioCliente usuarioCliente);

    public boolean existeUsuarioCliente(UsuarioCliente usuarioCliente);

    public UsuarioCliente obtenerUsuarioCliente(UsuarioCliente usuarioCliente);
}
