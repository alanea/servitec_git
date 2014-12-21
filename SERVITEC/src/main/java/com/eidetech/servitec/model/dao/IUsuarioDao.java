/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;

/**
 *
 * @author usuario-xp
 */
public interface IUsuarioDao {

    public static final String PRE_USUARIO = "USR";

    public boolean agregarUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public boolean agregarUsuarioCliente(UsuarioCliente usuarioCliente);

    public boolean existeUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public boolean existeUsuarioCliente(UsuarioCliente usuarioCliente);

    public UsuarioPersonal obtenerUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public UsuarioCliente obtenerUsuarioCliente(UsuarioCliente usuarioCliente);

}
