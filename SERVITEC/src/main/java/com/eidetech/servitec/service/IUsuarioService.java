/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service;

import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;


/**
 *
 * @author usuario-xp
 */
public interface IUsuarioService {

    public UsuarioPersonal loginUsuarioPersonal(UsuarioPersonal usuarioPersonal);
    public UsuarioCliente loginUsuarioCliente(UsuarioCliente usuarioCliente);

}
