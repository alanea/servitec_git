/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IConfiguracionDao;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("ConfiguracionDao")
public class ConfiguracionDao implements IConfiguracionDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        return UtilHibernate.agregarEntidad(sessionFactory, menu);
    }

    @Override
    public boolean agregarConfiguracionSubmenuPersonal(ConfiguracionSubmenu submenu) {
        return UtilHibernate.agregarEntidad(sessionFactory, submenu);
    }

    @Override
    public boolean agregarConfiguracionPermisoPersonal(ConfiguracionPermiso permiso) {
        return UtilHibernate.agregarEntidad(sessionFactory, permiso);
    }

    @Override
    public boolean agregarConfiguracionPermisoCliente(ConfiguracionPermisoCliente permiso) {
        return UtilHibernate.agregarEntidad(sessionFactory, permiso);
    }

    @Override
    public ConfiguracionMenu obtenerConfiguracionMenuPersonal(ConfiguracionMenu menu) {
        ConfiguracionMenu e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM ConfiguracionMenu u WHERE u.dnombre= :tipo_menu");
            q.setParameter("tipo_menu", menu.getDnombre());
            e = (ConfiguracionMenu) q.uniqueResult();
        } catch (ConstraintViolationException he) {
            System.out.println("excepcion01: " + he);
            session.getTransaction().rollback();
        } catch (TransactionException he) {
            System.out.println("excepcion02: " + he);
            session.getTransaction().rollback();
        } catch (HibernateException he) {
            System.out.println("excepcion03: " + he);
            session.getTransaction().rollback();
        } finally {
            session.getTransaction().commit();
            session.close();
        }
        return e;
    }

    @Override
    public List<ConfiguracionPermisoCliente> obtenerListaPermisoCliente() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, ConfiguracionPermisoCliente.class);
    }

}
