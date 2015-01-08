/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao.impl;

import com.eidetech.model.dao.IUbigeoDao;
import com.eidetech.model.domain.entity.UbigeoDepartamento;
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
        return UtilHibernate.obtenerListaEntidades(sessionFactory, UbigeoDepartamento.class);
    }

}
