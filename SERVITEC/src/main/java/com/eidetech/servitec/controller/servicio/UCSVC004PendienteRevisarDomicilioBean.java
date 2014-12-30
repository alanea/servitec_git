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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "pendienteRevisarDomicilio")
@ViewScoped
public class UCSVC004PendienteRevisarDomicilioBean implements Serializable {

    private List<Reservacion> listaFiltrada;
    private List<Reservacion> lista;
    private Reservacion reservacion;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSVC004PendienteRevisarDomicilioBean
     */
    public UCSVC004PendienteRevisarDomicilioBean() {
    }

    @PostConstruct
    public void init() {
        lista = beanUsuario.getTecnicoService().listaPendienteRevisarDomicilio();
        if (lista == null) {
            lista = new ArrayList();
        }
    }

    public void confirmarAsistencia() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        if (reservacion != null) {
            if (beanUsuario.getTecnicoService().registrarPendienteReparar(reservacion)) {
                msg = new FacesMessage("Exito", "Se confirmo la asistencia");
                exito = true;
            } else {
                msg = new FacesMessage("Error", "No se confirmo la asistencia");
            }
            FacesContext.getCurrentInstance().addMessage("growl_actualizacion", msg);
            if (exito) {
                String indexUsuario = "usuario_pendiente_domicilio.xhtml";
                requestContext.addCallbackParam("view", indexUsuario);
                requestContext.addCallbackParam("estaRegistrado", true);
            } else {
                requestContext.addCallbackParam("estaRegistrado", false);
            }
        }
    }

    public void confirmarInasistencia() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        if (reservacion != null) {
            if (beanUsuario.getTecnicoService().registrarNoReparar(reservacion)) {
                msg = new FacesMessage("Exito", "Se confirmo la inasistencia");
                exito = true;
            } else {
                msg = new FacesMessage("Error", "No se confirmo la inasistencia");
            }
            FacesContext.getCurrentInstance().addMessage("growl_actualizacion", msg);
            if (exito) {
                String indexUsuario = "usuario_pendiente_domicilio.xhtml";
                requestContext.addCallbackParam("view", indexUsuario);
                requestContext.addCallbackParam("estaRegistrado", true);
            } else {
                requestContext.addCallbackParam("estaRegistrado", false);
            }
        }
    }

    public List<Reservacion> getLista() {
        return lista;
    }

    public List<Reservacion> getListaFiltrada() {
        return listaFiltrada;
    }

    public void setListaFiltrada(List<Reservacion> listaFiltrada) {
        this.listaFiltrada = listaFiltrada;
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
