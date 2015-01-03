/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IReservacionDao;
import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.util.UtilCadena;
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
@Repository("ReservacionDao")
public class ReservacionDao implements IReservacionDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarReservacion(Reservacion reservacion) {
        boolean success = false;
        String id = "" + PRE_RESERVACION;
        Integer n;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(e.id_reservacion,5,11),int))  FROM Reservacion e ").uniqueResult();
            if (n == null) {
                n = 0;
            }
            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%05d", n);
            id = id + fmt.toString();

            reservacion.setId_reservacion(id);
            session.persist(reservacion);
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
    public boolean actualizarReservacion(Reservacion reservacion) {
        return UtilHibernate.actualizarEntidad(sessionFactory, reservacion);
    }

    @Override
    public List<Reservacion> obtenerListaReservacion(Cliente cliente) {
        List<Reservacion> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM Reservacion u WHERE u.cliente.id_cliente= :cliente_id");
            q.setParameter("cliente_id", cliente.getId_cliente());
            l = (List<Reservacion>) q.list();

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
    public List<Reservacion> obtenerListaReservacion(Reservacion reservacion) {
        List<Reservacion> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();

            String sql = "FROM Reservacion u WHERE ";
            int i=0;
            if (UtilCadena.cadenaValido(reservacion.getDtipoDireccion())) {
                String add="u.dtipoDireccion= :lugar";
                if(i>0){
                    add=" AND "+add;                    
                }
                sql=sql+add;
                i++;
            }
            if (UtilCadena.cadenaValido(reservacion.getDestadoReservacion())) {
                String add="u.destadoReservacion= :estado_reservacion";
                if(i>0){
                    add=" AND "+add;                    
                }
                sql=sql+add;
                i++;
            }
            if (UtilCadena.cadenaValido(reservacion.getDestadoServicio())) {
                String add="u.destadoServicio= :estado_servicio";
                if(i>0){
                    add=" AND "+add;                    
                }
                sql=sql+add;
                i++;
            }

            Query q = session.createQuery(sql);
            if (UtilCadena.cadenaValido(reservacion.getDtipoDireccion())) {
                q.setParameter("lugar", reservacion.getDtipoDireccion());
            }
            if (UtilCadena.cadenaValido(reservacion.getDestadoReservacion())) {
                q.setParameter("estado_reservacion", reservacion.getDestadoReservacion());
            }
            if (UtilCadena.cadenaValido(reservacion.getDestadoServicio())) {
                q.setParameter("estado_servicio", reservacion.getDestadoServicio());
            }
            l = (List<Reservacion>) q.list();

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
