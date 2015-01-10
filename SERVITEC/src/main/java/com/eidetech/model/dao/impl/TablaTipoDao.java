/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.ITablaTipoDao;
import com.eidetech.model.domain.entity.TablaTipo;
import com.eidetech.model.util.UtilCadena;
import com.eidetech.model.util.UtilHibernate;
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
@Repository("TablaTipoDao")
public class TablaTipoDao implements ITablaTipoDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarTabla(TablaTipo tabla) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Query q1 = session.createQuery("SELECT MAX(t.id_tabla) FROM TablaTipo t");
            Integer n1 = (Integer) q1.uniqueResult();
            if (n1 == null) {
                n1 = 0;
            }
            n1 = n1 + 1;

            Query q = session.createQuery("SELECT MAX(cast(t.dtipo,int)) FROM TablaTipo t WHERE t.dtabla= :tabla");
            q.setParameter("tabla", "0");
            Integer n = (Integer) q.uniqueResult();
            if (n == null) {
                n = 0;
            }
            n = n + 1;

            tabla.setId_tabla(n1);
            tabla.setDtabla("0");
            tabla.setDtipo("" + n);

            session.persist(tabla);
            session.flush();
            success = true;
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

        return success;
    }

    @Override
    public boolean agregarTipo(TablaTipo tipo) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query q1 = session.createQuery("SELECT MAX(t.id_tabla) FROM TablaTipo t");
            Integer n1 = (Integer) q1.uniqueResult();
            if (n1 == null) {
                n1 = 0;
            }
            n1 = n1 + 1;

            if (!UtilCadena.cadenaValido(tipo.getDtipo())) {
                Query q = session.createQuery("SELECT cast(COUNT(t.dtipo),int) FROM TablaTipo t WHERE t.dtabla= :tabla");
                q.setParameter("tabla", tipo.getDtabla());
                Integer n = (Integer) q.uniqueResult();
                if (n == null) {
                    n = 0;
                }

                n = n + 1;
                tipo.setDtipo("" + n);
            }

            tipo.setId_tabla(n1);
            session.persist(tipo);
            session.flush();
            success = true;
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

        return success;
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
        List<TablaTipo> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM TablaTipo u ORDER BY u.ddescripcion ASC");
            l = (List<TablaTipo>) q.list();
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
