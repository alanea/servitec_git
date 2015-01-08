/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.service;

import com.eidetech.model.domain.entity.Cliente;
import com.eidetech.model.domain.entity.Empresa;
import com.eidetech.model.domain.entity.Persona;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IVentaService {
    
    public List<Empresa> listaEmpresa();

    public List<Persona> listaPersona();

    public List<Cliente> listaCliente();

    public boolean modificarPersona(Persona persona);

    public boolean modificarEmpresa(Empresa empresa);

    public boolean modificarCliente(Cliente cliente);
}
