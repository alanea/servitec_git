/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IUsuarioClienteDao;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
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
@Repository("UsuarioClienteDao")
public class UsuarioClienteDao implements IUsuarioClienteDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarUsuarioCliente(UsuarioCliente usuario) {
        String id = "" + PRE_USUARIO;
        Integer n;

        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            Query q = session.createQuery("FROM UsuarioCliente u WHERE u.dname= :nombre");
            q.setParameter("nombre", usuario.getDname());
            UsuarioCliente e = (UsuarioCliente) q.uniqueResult();
            if (e != null) {
                return false;
            }
            
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_usuario,4,6),int))  FROM UsuarioCliente e ").uniqueResult();
            if (n == null) {
                n = 0;
            }
            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%06d", n);
            id = id + fmt.toString();
            usuario.setId_usuario(id);

            session.persist(usuario.getPersona());
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
    public boolean existeUsuarioCliente(UsuarioCliente usuario) {
        return obtenerUsuarioCliente(usuario) != null;
    }

    @Override
    public UsuarioCliente obtenerUsuarioCliente(UsuarioCliente usuarioCliente) {
        UsuarioCliente e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UsuarioCliente u WHERE u.dname= :nombre AND u.dpassword= :clave");
            q.setParameter("nombre", usuarioCliente.getDname());
            q.setParameter("clave", usuarioCliente.getDpassword());
            e = (UsuarioCliente) q.uniqueResult();
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
