/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import java.util.List;

/**
 *
 * @author usuario-xp
 */
public interface IUsuarioPersonalDao {

    public static final String PRE_USUARIO = "USR";

    public boolean agregarUsuarioPersonal(UsuarioPersonal usuarioPersonal);
    
    public boolean actualizarUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public boolean existeUsuarioPersonal(UsuarioPersonal usuarioPersonal);

    public UsuarioPersonal obtenerUsuarioPersonal(UsuarioPersonal usuarioPersonal);
    
    public List<UsuarioPersonal> obtenerListaUsuarioPersonal(Sede sede);
}
