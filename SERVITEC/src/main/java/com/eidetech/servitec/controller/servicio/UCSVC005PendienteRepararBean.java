/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.servicio;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "pendienteReparar")
@ViewScoped
public class UCSVC005PendienteRepararBean implements Serializable{

    private List<Reservacion> listaReservacion;
    private List<Reservacion> listaReservacionFiltrado;
    private Reservacion reservacion;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSVC005PendienteRepararBean
     */
    public UCSVC005PendienteRepararBean() {
    }
    @PostConstruct
    public void init() {
        listaReservacion = beanUsuario.getTecnicoService().listaPendienteReparar();
        if (listaReservacion == null) {
            listaReservacion = new ArrayList();
        }
    }

    public List<Reservacion> getListaReservacion() {
        return listaReservacion;
    }

    public void setListaReservacion(List<Reservacion> listaReservacion) {
        this.listaReservacion = listaReservacion;
    }

    public List<Reservacion> getListaReservacionFiltrado() {
        return listaReservacionFiltrado;
    }

    public void setListaReservacionFiltrado(List<Reservacion> listaReservacionFiltrado) {
        this.listaReservacionFiltrado = listaReservacionFiltrado;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
