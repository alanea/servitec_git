/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.model.dao;

import com.eidetech.servitec.model.domain.entity.Cliente;


/**
 *
 * @author usuario-xp
 */
public interface  IClienteDao {

    public boolean agregarCliente(Cliente cliente);

    public Cliente obtenerCliente(Cliente cliente);
}
