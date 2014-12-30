/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.servicio;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginClienteBean;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import com.eidetech.servitec.model.util.UtilServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mostrarEstado")
@ViewScoped
public class UCSVC002MostrarEstadoBean implements Serializable {

    private List<Reservacion> listaPendienteRevisar;
    private List<Reservacion> listaPendienteReparar;
    private List<Reservacion> listaReparados;
    private List<Reservacion> listaNoReparados;
    @ManagedProperty(value = "#{loginCliente}")
    private UCSYS001LoginClienteBean beanCliente;

    /**
     * Creates a new instance of UCSVC002MostrarEstadoBean
     */
    public UCSVC002MostrarEstadoBean() {
    }

    @PostConstruct
    public void init() {
        Set<Reservacion> l = beanCliente.getUsuario().getCliente().getReservaciones();
        List<Reservacion> lr = new ArrayList();
        lr.addAll(l);
        listaPendienteRevisar = UtilServicio.reservacionPendienteRevisarDomicilio(lr);
        listaPendienteReparar = UtilServicio.reservacionPendienteReparar(lr);
        listaReparados = UtilServicio.reservacionReparados(lr);
        listaNoReparados = UtilServicio.reservacionNoReparados(lr);
    }

    public UCSYS001LoginClienteBean getBeanCliente() {
        return beanCliente;
    }

    public void setBeanCliente(UCSYS001LoginClienteBean beanCliente) {
        this.beanCliente = beanCliente;
    }

    public List<Reservacion> getListaPendienteRevisar() {
        return listaPendienteRevisar;
    }

    public List<Reservacion> getListaPendienteReparar() {
        return listaPendienteReparar;
    }

    public List<Reservacion> getListaReparados() {
        return listaReparados;
    }

    public List<Reservacion> getListaNoReparados() {
        return listaNoReparados;
    }

}
