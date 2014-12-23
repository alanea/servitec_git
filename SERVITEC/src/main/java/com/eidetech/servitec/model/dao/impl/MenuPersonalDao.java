/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IMenuPersonal;
import com.eidetech.servitec.model.domain.entity.Menu;
import com.eidetech.servitec.model.domain.entity.Permiso;
import com.eidetech.servitec.model.domain.entity.Submenu;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("MenuPersonalDao")
public class MenuPersonalDao implements IMenuPersonal, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarMenuPersonal(Menu menu) {
        return UtilHibernate.agregarEntidad(sessionFactory, menu);
    }

    @Override
    public boolean agregarSubmenuPersonal(Submenu submenu) {
        return UtilHibernate.agregarEntidad(sessionFactory, submenu);
    }

    @Override
    public boolean agregarPermisoPersonal(Permiso permiso) {
        return UtilHibernate.agregarEntidad(sessionFactory, permiso);
    }

    @Override
    public boolean eliminarSubmenuPersonal(Submenu submenu) {
        return UtilHibernate.eliminarEntidad(sessionFactory, submenu);
    }

    @Override
    public boolean eliminarPermisoPersonal(Permiso permiso) {
        return UtilHibernate.eliminarEntidad(sessionFactory, permiso);
    }
}
