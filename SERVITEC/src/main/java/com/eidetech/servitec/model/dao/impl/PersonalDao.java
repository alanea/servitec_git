/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IPersonalDao;
import com.eidetech.servitec.model.domain.entity.Personal;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.Formatter;
import java.util.List;
import org.hibernate.HibernateException;
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
@Repository("PersonalDao")
public class PersonalDao implements IPersonalDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarPersonal(Personal personal) {
        personal.setId_personal(idPersonal());
        return UtilHibernate.agregarEntidad(sessionFactory, personal);
    }

    @Override
    public boolean actualizarPersonal(Personal personal) {
        return UtilHibernate.actualizarEntidad(sessionFactory, personal);
    }

    @Override
    public Personal obtenerPersonal(Personal personal) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Personal.class, personal.getId_personal());
    }

    @Override
    public List<Personal> obtenerTodoPersonal() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Personal.class);
    }

    private String idPersonal() {
        String id = "" + PRE_PERSONAL;
        Integer n = null;
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(p.id_personal,4,9),int))  FROM Personal p ").uniqueResult();
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
        if (n == null) {
            System.out.println("nulo");
            n = 0;
        }

        n = n + 1;
        Formatter fmt = new Formatter();
        fmt.format("%05d", n);

        id = id + fmt.toString();

        return id;
    }

    @Override
    public boolean agregarListaPersonal(List<Personal> lista) {
    return UtilHibernate.agregarListaEntidad(sessionFactory, lista);
    }
}
