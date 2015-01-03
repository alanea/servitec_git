/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.service.impl;

import com.eidetech.servitec.model.dao.IProductoClienteDao;
import com.eidetech.servitec.model.dao.IReservacionDao;
import com.eidetech.servitec.model.domain.entity.ProductoCliente;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilCadena;
import com.eidetech.servitec.model.util.UtilServicio;
import com.eidetech.servitec.model.util.validator.ValidatorReservacion;
import com.eidetech.servitec.service.IServicioTecnicoService;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author laptop-w8
 */
@Service("servicioTecnicoService")
@Transactional(readOnly = true)
public class ServicioTecnicoService implements IServicioTecnicoService, Serializable {
    
    @Autowired
    IReservacionDao reservacionDao;
    @Autowired
    IProductoClienteDao productoClienteDao;
    
    @Override
    public boolean registrarNuevoReservacion(UsuarioCliente usuarioCliente, Reservacion reservacion) {
        if (!ValidatorReservacion.esValidoReservacion(reservacion)) {
            return false;
        }
        ProductoCliente p = new ProductoCliente();
        p.setDproducto(reservacion.getDproducto());
        p.setDcategoria(reservacion.getDcategoria_producto());
        p.setCliente(usuarioCliente.getCliente());
        
        if (usuarioCliente.getCliente().getProductos() != null) {
            if (!usuarioCliente.getCliente().getProductos().contains(p)) {
                productoClienteDao.agregarProducto(p);
            }
        } else {
            productoClienteDao.agregarProducto(p);
        }
        
        reservacion.setDtipoDireccion(UtilServicio.TIPO_LUGAR_SERVICIO_FUERA);
        reservacion.setDestadoReservacion(UtilServicio.TIPO_REPARACION_PENDIENTE_REVISAR);
        reservacion.setDestadoServicio(UtilServicio.TIPO_SERVICIO_PENDIENTE);
        reservacion.setFcreacion(new Date());
        return reservacionDao.agregarReservacion(reservacion);
    }
    
    @Override
    public List<Reservacion> listaPendienteRevisarDomicilio() {
        Reservacion r = new Reservacion();
        
        r.setDtipoDireccion(UtilServicio.TIPO_LUGAR_SERVICIO_FUERA);
        r.setDestadoServicio(UtilServicio.TIPO_SERVICIO_PENDIENTE);
        
        return reservacionDao.obtenerListaReservacion(r);
    }
    
    @Override
    public List<Reservacion> listaPendienteRevisar() {
        Reservacion r = new Reservacion();
        r.setDestadoServicio(UtilServicio.TIPO_SERVICIO_PENDIENTE);
        
        return reservacionDao.obtenerListaReservacion(r);
    }
    
    @Override
    public List<Reservacion> listaPendienteReparar() {
        Reservacion r = new Reservacion();
        r.setDestadoReservacion(UtilServicio.TIPO_REPARACION_PENDIENTE_REPARAR);
        r.setDestadoServicio(UtilServicio.TIPO_SERVICIO_ACEPTADO);
        
        return reservacionDao.obtenerListaReservacion(r);
    }
    
    @Override
    public List<Reservacion> listaReparados() {
        Reservacion r = new Reservacion();
        r.setDestadoReservacion(UtilServicio.TIPO_REPARACION_REPARADO);
        r.setDestadoServicio(UtilServicio.TIPO_SERVICIO_ACEPTADO);
        
        return reservacionDao.obtenerListaReservacion(r);
    }
    
    @Override
    public List<Reservacion> listaNoReparados() {
        Reservacion r = new Reservacion();
        r.setDestadoReservacion(UtilServicio.TIPO_REPARACION_NO_REPARADO);
        
        return reservacionDao.obtenerListaReservacion(r);
    }
    
    @Override
    public boolean registrarPendienteReparar(UsuarioPersonal usuarioPersonal,Reservacion reservacion) {
        if (reservacion == null || !UtilCadena.cadenaValido(reservacion.getDestadoReservacion())) {
            return false;
        }
        reservacion.setDestadoReservacion(UtilServicio.TIPO_REPARACION_PENDIENTE_REPARAR);
        reservacion.setDestadoServicio(UtilServicio.TIPO_SERVICIO_ACEPTADO);
        reservacion.setDuserRevisor(usuarioPersonal.getId_usuario());
        reservacion.setFmodificacion(new Date());
        return reservacionDao.actualizarReservacion(reservacion);
    }
    
    @Override
    public boolean registrarNoReparar(UsuarioPersonal usuarioPersonal,Reservacion reservacion) {
        if (reservacion == null || !UtilCadena.cadenaValido(reservacion.getDestadoReservacion())) {
            return false;
        }
        reservacion.setDestadoReservacion(UtilServicio.TIPO_REPARACION_NO_REPARADO);
        reservacion.setDuserRevisor(usuarioPersonal.getId_usuario());
        reservacion.setFmodificacion(new Date());
        return reservacionDao.actualizarReservacion(reservacion);
    }
    
}
