/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.ISedeDao;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
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

    @Override
    public List<UsuarioPersonal> obtenerListaUsuario(Sede sede) {
    List<UsuarioPersonal> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Usuario u WHERE u.sede.id_sede= :nombre_sede");
            q.setParameter("nombre_sede", sede.getId_sede());
            l = (List<UsuarioPersonal>) q.list();
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
        return l;
    }

}
