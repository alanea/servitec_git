/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IProductoClienteDao;
import com.eidetech.model.domain.entity.Cliente;
import com.eidetech.model.domain.entity.HistorialProductoCliente;
import com.eidetech.model.domain.entity.ProductoCliente;
import com.eidetech.model.util.UtilHibernate;
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
@Repository("ProductoClienteDao")
public class ProductoClienteDao implements IProductoClienteDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarProducto(ProductoCliente productoCliente) {
        boolean success = false;
        String PRE_PRODUCTO = "PRO";
        String id = "" + PRE_PRODUCTO;
        Integer n;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_producto_cliente,4,6),int)) FROM ProductoCliente e ").uniqueResult();
            
            if (n == null) {
                n = 0;
            }
            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%06d", n);
            id = id + fmt.toString();
            id = id + productoCliente.getDproducto();

            productoCliente.setId_producto_cliente(id);
            session.persist(productoCliente);
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
    public boolean actualizarProducto(ProductoCliente productoCliente) {
        return UtilHibernate.actualizarEntidad(sessionFactory, productoCliente);
    }

    @Override
    public List<ProductoCliente> obtenerListaProducto(Cliente cliente) {
        List<ProductoCliente> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM ProductoCliente u WHERE u.cliente.id_cliente= :cliente_id");
            q.setParameter("cliente_id", cliente.getId_cliente());
            l = (List<ProductoCliente>) q.list();

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
    public boolean agregarHistorialProducto(HistorialProductoCliente historialProductoCliente) {
    boolean success = false;
        String PRE_HISTORIAL = "HST";
        String id = "" + PRE_HISTORIAL;
        Integer n;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_historial_producto_cliente,4,5),int))  FROM HistorialProductoCliente e ").uniqueResult();
            if (n == null) {
                n = 0;
            }
            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%06d", n);
            id = id + fmt.toString();
            id = id + historialProductoCliente.getProducto().getId_producto_cliente();

            historialProductoCliente.setId_historial_producto_cliente(id);
            session.persist(historialProductoCliente);
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
    public boolean actualizarHistorialProducto(HistorialProductoCliente historialProductoCliente) {
        return UtilHibernate.actualizarEntidad(sessionFactory, historialProductoCliente);
    }

}
