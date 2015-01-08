/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.Cliente;
import java.util.List;


/**
 *
 * @author usuario-xp
 */
public interface  IClienteDao {

    public boolean agregarCliente(Cliente cliente);

    public Cliente obtenerCliente(Cliente cliente);
    
    public boolean actualizarCliente(Cliente cliente);
    
    public List<Cliente> obtenerListaCliente();
}
