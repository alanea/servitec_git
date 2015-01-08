/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.ISedeDao;
import com.eidetech.model.domain.entity.Sede;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("SedeDao")
public class SedeDao implements ISedeDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarSede(Sede sede) {
        return UtilHibernate.agregarEntidad(sessionFactory, sede);
    }

    @Override
    public boolean actualizarSede(Sede sede) {
        return UtilHibernate.actualizarEntidad(sessionFactory, sede);
    }

    @Override
    public Sede obtenerSede(Sede sede) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Sede.class, sede.getId_sede());
    }

    @Override
    public List<Sede> obtenerListaSedes() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Sede.class);
    }

    @Override
    public boolean agregarListaSede(List<Sede> sedes) {
        return UtilHibernate.agregarListaEntidad(sessionFactory, sedes);
    }
}
