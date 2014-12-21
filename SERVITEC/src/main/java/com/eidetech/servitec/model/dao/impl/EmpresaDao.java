/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IEmpresaDao;
import com.eidetech.servitec.model.domain.entity.Empresa;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("EmpresaDao")
public class EmpresaDao implements IEmpresaDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarEmpresa(Empresa empresa) {
        return UtilHibernate.agregarEntidad(sessionFactory, empresa);
    }

    @Override
    public Empresa obtenerEmpresa(Empresa empresa) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Empresa.class, empresa.getId_empresa());
    }

}
