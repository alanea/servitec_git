/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.ITablaTipoDao;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("TablaTipoDao")
public class TablaTipoDao implements ITablaTipoDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarTablaTipo(TablaTipo tablaTipo) {
        return UtilHibernate.agregarEntidad(sessionFactory, tablaTipo);
    }

    @Override
    public boolean agregarTodoTablaTipo(List<TablaTipo> lista) {
        return UtilHibernate.agregarListaEntidad(sessionFactory, lista);
    }

    @Override
    public boolean actualizarTablaTipo(TablaTipo tablaTipo) {
        return UtilHibernate.actualizarEntidad(sessionFactory, tablaTipo);
    }

    @Override
    public List<TablaTipo> obtenerTodoTablaTipo() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, TablaTipo.class);
    }

}
