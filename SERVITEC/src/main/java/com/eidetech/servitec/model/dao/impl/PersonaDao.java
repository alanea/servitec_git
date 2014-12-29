/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IPersonaDao;
import com.eidetech.servitec.model.domain.entity.Persona;
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
@Repository("PersonaDao")
public class PersonaDao implements IPersonaDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarPersona(Persona persona) {
        persona.setId_persona(idPersona());
        return UtilHibernate.agregarEntidad(sessionFactory, persona);
    }

    @Override
    public boolean actualizarPersona(Persona persona) {
        return UtilHibernate.actualizarEntidad(sessionFactory, persona);
    }

    @Override
    public Persona obtenerPersona(Persona persona) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Persona.class, persona.getId_persona());
    }

    @Override
    public List<Persona> obtenerTodoPersona() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Persona.class);
    }

    @Override
    public boolean agregarListaPersona(List<Persona> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String idPersona() {
        String id = "" + PRE_PERSONA;
        Integer n = null;
        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(p.id_persona,4,9),int))  FROM Persona p ").uniqueResult();
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
    public boolean existePersona(Persona persona) {
        return obtenerPersona(persona) != null;
    }
}
