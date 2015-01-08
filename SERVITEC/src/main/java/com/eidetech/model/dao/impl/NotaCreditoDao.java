/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.INotaCreditoDao;
import com.eidetech.model.domain.entity.NotaCredito;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author laptop-w8
 */
@Repository("NotaCreditoDao")
public class NotaCreditoDao implements INotaCreditoDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarNotaCredito(NotaCredito notacredito) {
        return UtilHibernate.agregarEntidad(sessionFactory, notacredito);
    }

}
