/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IMenuClienteDao;
import com.eidetech.servitec.model.domain.entity.PermisoCliente;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("MenuClienteDao")
public class MenuClienteDao implements IMenuClienteDao,Serializable{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean actualizarPermisoCliente(PermisoCliente permiso) {
    return UtilHibernate.actualizarEntidad(sessionFactory, permiso);
    }
}
