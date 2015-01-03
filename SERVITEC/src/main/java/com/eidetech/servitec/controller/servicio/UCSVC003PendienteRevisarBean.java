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
@ManagedBean(name = "pendienteRevisar")
@ViewScoped
public class UCSVC003PendienteRevisarBean implements Serializable{

    private List<Reservacion> listaReservacion;
    private List<Reservacion> listaReservacionFiltrado;
    private Reservacion reservacion;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSVS003PendienteRevisarBean
     */
    public UCSVC003PendienteRevisarBean() {
    }
    
    @PostConstruct
    public void init() {
        listaReservacion = beanUsuario.getTecnicoService().listaPendienteRevisarDomicilio();
        if (listaReservacion == null) {
            listaReservacion = new ArrayList();
        }
    }
    
    public void registrarPendienteReparar(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        if (beanUsuario.getTecnicoService().registrarPendienteReparar(beanUsuario.getUsuario(),reservacion)) {
            
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se confirmo una nueva reparacion");
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se confirmo la reparacion");
        }
        FacesContext.getCurrentInstance().addMessage("growl_actualizacion", msg);
        if (exito) {
            String indexUsuario = "usuario_equipo_pendiente_revisar.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }
    
    public void registrarCancelarReparacion(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        if (beanUsuario.getTecnicoService().registrarNoReparar(beanUsuario.getUsuario(),reservacion)) {
            
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Se confirmo la cancelacion de la reparacion");
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se confirmo la no reparacion");
        }
        FacesContext.getCurrentInstance().addMessage("growl_actualizacion", msg);
        if (exito) {
            String indexUsuario = "usuario_equipo_pendiente_revisar.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public List<Reservacion> getListaReservacion() {
        return listaReservacion;
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
