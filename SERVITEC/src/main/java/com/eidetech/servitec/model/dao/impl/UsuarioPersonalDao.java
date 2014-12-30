/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IUsuarioPersonalDao;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import java.io.Serializable;
import java.util.Formatter;
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
@Repository("UsuarioPersonalDao")
public class UsuarioPersonalDao implements IUsuarioPersonalDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarUsuarioPersonal(UsuarioPersonal usuario) {
        boolean success = false;
        String id = "" + PRE_USUARIO;
        Integer n;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.dname= :nombre");
            q.setParameter("nombre", usuario.getDname());
            UsuarioPersonal e = (UsuarioPersonal) q.uniqueResult();
            if (e != null) {
                return false;
            }
            
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_usuario,4,6),int))  FROM UsuarioPersonal e ").uniqueResult();
            if (n == null) {
                n = 0;
            }
            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%06d", n);
            id = id + fmt.toString();

            usuario.setId_usuario(id);
            session.persist(usuario);            
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
    public boolean existeUsuarioPersonal(UsuarioPersonal usuario) {
        UsuarioPersonal e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.dname= :nombre");
            q.setParameter("nombre", usuario.getDname());
            e = (UsuarioPersonal) q.uniqueResult();
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

        return e!=null;
    }

    @Override
    public UsuarioPersonal obtenerUsuarioPersonal(UsuarioPersonal usuario) {
        UsuarioPersonal e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioPersonal u WHERE u.dname= :nombre AND u.dpassword= :clave");
            q.setParameter("nombre", usuario.getDname());
            q.setParameter("clave", usuario.getDpassword());
            e = (UsuarioPersonal) q.uniqueResult();
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

}
