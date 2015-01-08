/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.ITalonDao;
import com.eidetech.model.domain.entity.Serie;
import com.eidetech.model.domain.entity.Talon;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilHibernate;
import com.eidetech.model.util.validator.ValidatorTalon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
@Repository("TalonDao")
public class TalonDao implements ITalonDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarTalon(Talon talon) {

        talon.setFcreacion(new Date());
        List<Talon> talones = new ArrayList();
        talones.addAll(talon.getSerie().getTalones());

        return ValidatorTalon.talonPosible(talon, talones) && UtilHibernate.agregarEntidad(sessionFactory, talon);
    }

    @Override
    public boolean actualizarTalon(Talon talon) {
        return UtilHibernate.actualizarEntidad(sessionFactory, talon);
    }

    @Override
    public Talon obtenerTalon(Talon talon) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Talon.class, talon.getId_talon());
    }

    @Override
    public List<Talon> obtenerTodoTalon() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Talon.class);
    }

    @Override
    public List<Talon> obtenerTodoTalonSerie(Serie serie) {

        List<Talon> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Talon s WHERE s.serie.id_serie= :numero AND s.serie.dtipo= :tipo ");
            q.setParameter("numero", serie.getId_serie());
            q.setParameter("tipo", serie.getDtipo());
            l = (List<Talon>) q.list();
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

    @Override
    public List<Talon> obtenerTodoTalonUsuario(UsuarioPersonal usuario) {
        List<Talon> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Talon s WHERE s.duser= :usuario AND s.destado= :estado ");
            q.setParameter("usuario", usuario.getId_usuario());
            q.setParameter("estado", "1"); //activado
            l = (List<Talon>) q.list();
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
