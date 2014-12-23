/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IUsuarioDao;
import com.eidetech.servitec.model.domain.entity.Permiso;
import com.eidetech.servitec.model.domain.entity.Submenu;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilHibernate;
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
@Repository("UsuarioDao")
public class UsuarioDao implements IUsuarioDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarUsuarioPersonal(UsuarioPersonal usuario) {
        usuario.setId_usuario(idUsuarioPersonal());
        if (existeUsuarioPersonal(usuario)) {
            return false;
        }

        boolean success = false;
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();
            session.persist(usuario);
//            if (usuario.getMenu() != null) {
//                session.persist(usuario.getMenu());
//                if(usuario.getMenu().getSubmenus()!=null){
//                    for(Submenu s:usuario.getMenu().getSubmenus()){
//                        session.persist(s);
//                        if(s.getPermisos()!=null){
//                            for(Permiso p:s.getPermisos()){
//                                session.persist(p);
//                            }
//                        }else{
//                            System.out.println("vacio 2");
//                        }
//                    }
//                }else{
//                    System.out.println("vacio 1");
//                }
//            }
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
    public boolean agregarUsuarioCliente(UsuarioCliente usuario) {
        usuario.setId_usuario(idUsuarioCliente());
        return !existeUsuarioCliente(usuario) && UtilHibernate.agregarEntidad(sessionFactory, usuario);
    }

    @Override
    public boolean existeUsuarioPersonal(UsuarioPersonal usuario) {
        return obtenerUsuarioPersonal(usuario) != null;
    }

    @Override
    public boolean existeUsuarioCliente(UsuarioCliente usuario) {
        return obtenerUsuarioCliente(usuario) != null;
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

    private String idUsuarioPersonal() {
        String id = "" + PRE_USUARIO;
        Integer n = null;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_usuario,4,9),int))  FROM UsuarioPersonal e ").uniqueResult();
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

    private String idUsuarioCliente() {
        String id = "" + PRE_USUARIO;
        Integer n = null;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_usuario,4,9),int))  FROM UsuarioCliente e ").uniqueResult();
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
