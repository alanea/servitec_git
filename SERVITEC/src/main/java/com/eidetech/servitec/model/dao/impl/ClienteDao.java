/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao.impl;

import com.eidetech.servitec.model.dao.IClienteDao;
import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.util.UtilHibernate;
import java.io.Serializable;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 *
 * @author laptop-w8
 */
@Repository("ClienteDao")
public class ClienteDao implements IClienteDao, Serializable {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public boolean agregarCliente(Cliente cliente) {
        return UtilHibernate.agregarEntidad(sessionFactory, cliente);
    }

    @Override
    public Cliente obtenerCliente(Cliente cliente) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Cliente.class, cliente.getId_cliente());
    }

}
