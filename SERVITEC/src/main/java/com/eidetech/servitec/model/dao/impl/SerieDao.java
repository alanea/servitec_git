/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.ISerieDao;
import com.eidetech.servitec.model.domain.entity.Serie;
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
@Repository("SerieDao")
public class SerieDao implements ISerieDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarSerie(Serie serie) {
        return UtilHibernate.agregarEntidad(sessionFactory, serie);
    }

    @Override
    public Serie obtenerSerie(Serie serie) {
        Serie s = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Serie s WHERE s.id_serie= :numero AND s.dtipo= :tipo ");
            q.setParameter("numero", serie.getId_serie());
            q.setParameter("tipo", serie.getDtipo());
            s = (Serie) q.uniqueResult();
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
        return s;
    }

    @Override
    public List<Serie> obtenerTodoSerie() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Serie.class);
    }

}
