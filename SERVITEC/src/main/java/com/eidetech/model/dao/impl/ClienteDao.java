/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IClienteDao;
import com.eidetech.model.domain.entity.Cliente;
import com.eidetech.model.util.UtilHibernate;
import java.io.Serializable;
import java.util.List;
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
        return UtilHibernate.agregarActualizarEntidad(sessionFactory, cliente);
    }

    @Override
    public Cliente obtenerCliente(Cliente cliente) {
        return UtilHibernate.obtenerEntidad(sessionFactory, Cliente.class, cliente.getId_cliente());
    }

    @Override
    public boolean actualizarCliente(Cliente cliente) {
    return UtilHibernate.actualizarEntidad(sessionFactory, cliente);
    }

    @Override
    public List<Cliente> obtenerListaCliente() {
    return UtilHibernate.obtenerListaEntidades(sessionFactory, Cliente.class);
    }
}
