/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IProductoDao;
import com.eidetech.servitec.model.domain.entity.Producto;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.Formatter;
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
@Repository("ProductoDao")
public class ProductoDao implements IProductoDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarProducto(Producto producto) {
        if (producto.getId_producto() == null || producto.getId_producto().equals("")) {
            producto.setId_producto(idProducto());
        }
        return !existeProducto(producto) && UtilHibernate.agregarEntidad(sessionFactory, producto);
    }

    @Override
    public boolean agregarTodoProducto(List<Producto> lista) {
        return UtilHibernate.agregarListaEntidad(sessionFactory, lista);
    }

    @Override
    public boolean existeProducto(Producto producto) {
        Producto p = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Producto u WHERE u.especialidad.id_especialidad= :esp AND u.ddescripcion= :nombre");
            q.setParameter("nombre", producto.getDdescripcion());
            q.setParameter("esp", producto.getCategoria().getId_categoria());
            p = (Producto) q.uniqueResult();
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
        return p != null;
    }

    @Override
    public boolean actualizarProducto(Producto producto) {
        return UtilHibernate.actualizarEntidad(sessionFactory, producto);
    }

    @Override
    public Producto obtenerProducto(Producto producto) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Producto.class, producto.getId_producto());
    }

    @Override
    public List<Producto> obtenerTodoProducto() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Producto.class);
    }

    private String idProducto() {
        String id = "" + PRE_PRODUCTO;
        Integer n = null;

        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(p.id_producto,4,9),int))  FROM Producto p ").uniqueResult();
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
