/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IEmpresaDao;
import com.eidetech.model.domain.entity.Empresa;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.Formatter;
import java.util.List;
import org.hibernate.HibernateException;
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
@Repository("EmpresaDao")
public class EmpresaDao implements IEmpresaDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarEmpresa(Empresa empresa) {
        boolean success = false;
        String PRE_EMPRESA = "EMP";
        String id = "" + PRE_EMPRESA;
        Integer n;

        Session session = sessionFactory.openSession();
        try {
            session.getTransaction().begin();
            n = (Integer) session.createQuery("SELECT MAX(cast(substring(p.id_empresa,4,9),int))  FROM Empresa p ").uniqueResult();

            if (n == null) {
                n = 0;
            }

            n = n + 1;
            Formatter fmt = new Formatter();
            fmt.format("%05d", n);

            id = id + fmt.toString();

            empresa.setId_empresa(id);
            session.persist(empresa);
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
    public Empresa obtenerEmpresa(Empresa empresa) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Empresa.class, empresa.getId_empresa());
    }

    @Override
    public boolean actualizarEmpresa(Empresa empresa) {
        return UtilHibernate.actualizarEntidad(sessionFactory, empresa);
    }

    @Override
    public List<Empresa> obtenerListaEmpresa() {
        return UtilHibernate.obtenerListaEntidades(sessionFactory, Empresa.class);
    }

}
