/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service.impl;

import com.eidetech.servitec.model.dao.IUsuarioDao;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.service.IUsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioService implements IUsuarioService, Serializable {

    @Autowired
    IUsuarioDao usuarioDao;

    @Override
    public UsuarioPersonal loginUsuarioPersonal(UsuarioPersonal usuario) {
        return usuarioDao.obtenerUsuarioPersonal(usuario);
    }

    @Override
    public UsuarioCliente loginUsuarioCliente(UsuarioCliente usuarioCliente) {
    return usuarioDao.obtenerUsuarioCliente(usuarioCliente);
    }

}
