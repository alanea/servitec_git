/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IUbigeoDao;
import com.eidetech.model.domain.entity.UbigeoDepartamento;
import com.eidetech.model.domain.entity.UbigeoDistrito;
import com.eidetech.model.domain.entity.UbigeoProvincia;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
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
@Repository("UbigeoDao")
public class UbigeoDao implements IUbigeoDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarDepartamento(UbigeoDepartamento departamento) {
        return UtilHibernate.agregarEntidad(sessionFactory, departamento);
    }

    @Override
    public boolean agregarTodoDepartamento(List<UbigeoDepartamento> lista) {
        return UtilHibernate.agregarListaEntidad(sessionFactory, lista);
    }

    @Override
    public List<UbigeoDepartamento> obtenerTodoDepartamento() {
//        return UtilHibernate.obtenerListaEntidades(sessionFactory, UbigeoDepartamento.class);
        List<UbigeoDepartamento> l = null;
        Session session = sessionFactory.openSession();

        try {
            session.getTransaction().begin();
            Query q = session.createQuery("FROM UbigeoDepartamento u ORDER BY u.dcodigo ASC");
            l = (List<UbigeoDepartamento>) q.list();

            if (l != null && !l.isEmpty()) {
                for (UbigeoDepartamento ud : l) {
                    Query q1 = session.createQuery("FROM UbigeoProvincia up WHERE up.departamento.dcodigo= :departamento_id ORDER BY up.dnombre ASC");
                    q1.setParameter("departamento_id", ud.getDcodigo());
                    List<UbigeoProvincia> l1 = (List<UbigeoProvincia>) q1.list();
                    ud.setProvincias(new HashSet());

                    if (l1 != null && !l.isEmpty()) {
                        ud.getProvincias().addAll(l1);
                        ud.setListaProvincias(l1);
                        for (UbigeoProvincia up : l1) {
                            Query q2 = session.createQuery("FROM UbigeoDistrito ud WHERE ud.provincia.dcodigo= :provincia_id ORDER BY ud.dnombre ASC");
                            q2.setParameter("provincia_id", up.getDcodigo());
                            List<UbigeoDistrito> l2 = (List<UbigeoDistrito>) q2.list();
                            up.setDistritos(new HashSet());
                            if (l2 != null && !l2.isEmpty()) {
                                up.getDistritos().addAll(l2);
                                up.setListaDistritos(l2);
                            }
                        }
                    }
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

}
