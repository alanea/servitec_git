/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.dao;

import com.eidetech.model.domain.entity.UsuarioCliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public interface IUsuarioClienteDao {
 
    public static final String PRE_USUARIO = "USR";
    
    public boolean agregarUsuarioCliente(UsuarioCliente usuarioCliente);

    public boolean existeUsuarioCliente(UsuarioCliente usuarioCliente);
    
    public boolean actualizarUsuarioCliente(UsuarioCliente usuarioCliente);

    public UsuarioCliente obtenerUsuarioCliente(UsuarioCliente usuarioCliente);
    
    public List<UsuarioCliente> obtenerListaUsuarioCliente();
    
    public List<Date> obtenerListaFechaIngreso(Date fecha_inicio,Date fecha_fin,boolean todo_fecha);
}
