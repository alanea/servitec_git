/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service.impl;

import com.eidetech.model.dao.IPersonalDao;
import com.eidetech.model.domain.entity.Personal;
import com.eidetech.service.IRrhhService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("rrhhService")
@Transactional(readOnly = true)
public class RrhhService implements IRrhhService, Serializable {

    @Autowired
    IPersonalDao personalDao;

    @Override
    public boolean registrarNuevoPersonal(Personal personal) {
        return personalDao.agregarPersonal(personal);
    }

    @Override
    public List<Personal> listaPersonal() {
        return personalDao.obtenerTodoPersonal();
    }

    @Override
    public boolean modificarPersonal(Personal personal) {
        return personalDao.actualizarPersonal(personal);
    }
}
