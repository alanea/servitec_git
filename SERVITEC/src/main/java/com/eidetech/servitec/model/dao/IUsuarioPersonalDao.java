/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;

/**
 *
 * @author usuario-xp
 */
public interface IUsuarioPersonalDao {

    public static final String PRE_USUARIO = "USR";

    public boolean agregarUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public boolean existeUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public UsuarioPersonal obtenerUsuarioPersonal(UsuarioPersonal usuarioPersonal);
}
