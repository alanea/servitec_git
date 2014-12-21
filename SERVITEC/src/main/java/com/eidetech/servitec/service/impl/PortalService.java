/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service.impl;

import com.eidetech.servitec.model.dao.ITablaTipoDao;
import com.eidetech.servitec.model.dao.IUbigeoDao;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.domain.entity.UbigeoDepartamento;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.service.IPortalService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("portalService")
@Transactional(readOnly = true)
public class PortalService implements IPortalService, Serializable {

    @Autowired
    ITablaTipoDao tablaTipoDao;
    @Autowired
    IUbigeoDao ubigeoDao;

    @Override
    public List<TablaTipo> obtenerTablaTipos() {
        return tablaTipoDao.obtenerTodoTablaTipo();
    }

    @Override
    public List<UbigeoDepartamento> obtenerUbigeos() {
        return ubigeoDao.obtenerTodoDepartamento();
    }

    @Override
    public boolean registrarCliente(UsuarioCliente usuario) {
        return false;
    }
}
