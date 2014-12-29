/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service.impl;

import com.eidetech.servitec.model.dao.IClienteDao;
import com.eidetech.servitec.model.dao.IProductoClienteDao;
import com.eidetech.servitec.model.dao.IReservacionDao;
import com.eidetech.servitec.model.dao.IUsuarioClienteDao;
import com.eidetech.servitec.model.dao.IUsuarioPersonalDao;
import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.ProductoCliente;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.service.IUsuarioService;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("usuarioService")
@Transactional(readOnly = true)
public class UsuarioService implements IUsuarioService, Serializable {

    @Autowired
    IUsuarioPersonalDao usuarioPersonalDao;
    @Autowired
    IUsuarioClienteDao usuarioClienteDao;
    @Autowired
    IClienteDao clienteDao;
    @Autowired
    IReservacionDao reservacionDao;
    @Autowired
    IProductoClienteDao productoClienteDao;

    @Override
    public UsuarioPersonal loginUsuarioPersonal(UsuarioPersonal usuario) {
        return usuarioPersonalDao.obtenerUsuarioPersonal(usuario);
    }

    @Override
    public UsuarioCliente loginUsuarioCliente(UsuarioCliente usuarioCliente) {
        UsuarioCliente u = usuarioClienteDao.obtenerUsuarioCliente(usuarioCliente);
        if (u != null) {
            Cliente c = new Cliente();
            c.setId_cliente(u.getPersona().getId_persona());
            u.setCliente(clienteDao.obtenerCliente(c));

            List<Reservacion> lr = reservacionDao.obtenerListaReservacion(u.getCliente());
            u.getCliente().setReservaciones(new HashSet());
            if (lr != null) {
                u.getCliente().getReservaciones().addAll(lr);
            }

            List<ProductoCliente> lp = productoClienteDao.obtenerListaProducto(u.getCliente());
            u.getCliente().setProductos(new HashSet());
            if (lp != null) {
                u.getCliente().getProductos().addAll(lp);
            }
            return u;
        }
        return null;
    }

}
