/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.ICategoriaDao;
import com.eidetech.servitec.model.domain.entity.Categoria;
import com.eidetech.servitec.model.domain.entity.Producto;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.Formatter;
import java.util.HashSet;
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
@Repository("CategoriaDao")
public class CategoriaDao implements ICategoriaDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarCategoria(Categoria categoria) {
        if (categoria.getId_categoria() == null || categoria.getId_categoria().equals("")) {
            categoria.setId_categoria(idEspecialidad());
        }
        return !existeCategoria(categoria) && UtilHibernate.agregarEntidad(sessionFactory, categoria);
    }

    @Override
    public boolean agregarTodoCategoria(List<Categoria> lista) {
        boolean success = false;
        Session session = sessionFactory.openSession();
        Integer n;

        try {
            session.beginTransaction();
            for (Categoria o : lista) {
                String id = "" + PRE_ESPECIALIDAD;
                n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_categoria,4,6),int))  FROM Categoria e ").uniqueResult();
                if(n==null){
                    n=0;
                }
                n = n + 1;
                Formatter fmt = new Formatter();
                fmt.format("%06d", n);
                id = id + fmt.toString();
                System.out.println("id="+id);

                o.setId_categoria(id);
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

    @Override
    public boolean existeCategoria(Categoria especialidad) {
        Categoria e = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Categoria u WHERE u.dnombre= :nombre");
            q.setParameter("nombre", especialidad.getDnombre());
            e = (Categoria) q.uniqueResult();
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
        return e != null;
    }

    @Override
    public boolean actualizarCategoria(Categoria categoria) {
        return UtilHibernate.actualizarEntidad(sessionFactory, categoria);
    }

    @Override
    public Categoria obtenerCategoria(Categoria categoria) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Categoria.class, categoria.getId_categoria());
    }

    @Override
    public List<Categoria> obtenerTodoCategoria() {
        List<Categoria> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Categoria");
            l = (List<Categoria>) q.list();
            if (l != null && l.size() > 0) {
                for (Categoria e : l) {
                    Query q1 = session.createQuery("FROM Producto u WHERE u.categoria.id_categoria= :categoria_id");
                    q1.setParameter("categoria_id", e.getId_categoria());
                    List<Producto> l1 = (List<Producto>) q1.list();

                    e.setProductos(new HashSet());
                    e.getProductos().addAll(l1);
                }
            }
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

    private String idEspecialidad() {
        String id = "" + PRE_ESPECIALIDAD;
        Integer n = null;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_categoria,4,9),int))  FROM Categoria e ").uniqueResult();
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
}
