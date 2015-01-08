/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.service.impl;

import com.eidetech.model.dao.IClienteDao;
import com.eidetech.model.dao.IEmpresaDao;
import com.eidetech.model.dao.IPersonaDao;
import com.eidetech.model.domain.entity.Cliente;
import com.eidetech.model.domain.entity.Empresa;
import com.eidetech.model.domain.entity.Persona;
import com.eidetech.service.IVentaService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("ventaService")
@Transactional(readOnly = true)
public class VentaService implements IVentaService, Serializable {

    @Autowired
    IEmpresaDao empresaDao;
    @Autowired
    IPersonaDao personaDao;
    @Autowired
    IClienteDao clienteDao;

    @Override
    public List<Empresa> listaEmpresa() {
        return empresaDao.obtenerListaEmpresa();
    }

    @Override
    public List<Persona> listaPersona() {
        return personaDao.obtenerTodoPersona();
    }

    @Override
    public List<Cliente> listaCliente() {
        return clienteDao.obtenerListaCliente();
    }

    @Override
    public boolean modificarPersona(Persona persona) {
        return personaDao.actualizarPersona(persona);
    }

    @Override
    public boolean modificarEmpresa(Empresa empresa) {
        return empresaDao.actualizarEmpresa(empresa);
    }

    @Override
    public boolean modificarCliente(Cliente cliente) {
        return clienteDao.actualizarCliente(cliente);
    }

}
