/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.util;

import java.io.Serializable;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author laptop-w8
 */
public class UtilHibernate {

    public static boolean agregarEntidad(SessionFactory sessionFactory, Object object) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.persist(object);
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
    
    public static boolean agregarActualizarEntidad(SessionFactory sessionFactory, Object object) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.saveOrUpdate(object);
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

    public static <T> boolean agregarListaEntidad(SessionFactory sessionFactory, List<T> listObject) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            for (T o : listObject) {
                session.saveOrUpdate(o);
            }
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

    public static boolean actualizarEntidad(SessionFactory sessionFactory, Object object) {
        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.update(object);
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

    public static <T> T obtenerEntidad(SessionFactory sessionFactory, Class<T> claseEntidad, Serializable id) {

        T e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            e = (T) session.get(claseEntidad, id);
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

    public static boolean eliminarEntidad(SessionFactory sessionFactory, Object entidad) {

        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.delete(entidad);
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

    public static <T> List<T> obtenerListaEntidades(SessionFactory sessionFactory, Class<T> claseEntidad) {

        List<T> listaResultado = null;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            listaResultado = session.createQuery("FROM " + claseEntidad.getSimpleName()).list();
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

        return listaResultado;
    }
}
