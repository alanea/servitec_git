/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.servicio;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.HistorialProductoCliente;
import com.eidetech.model.domain.entity.Reservacion;
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
@ManagedBean(name = "pendienteReparar")
@ViewScoped
public class UCSVC005PendienteRepararBean implements Serializable {

    private List<Reservacion> listaReservacion;
    private List<Reservacion> listaReservacionFiltrado;
    private Reservacion reservacion;
    private HistorialProductoCliente historia;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSVC005PendienteRepararBean
     */
    public UCSVC005PendienteRepararBean() {
    }

    @PostConstruct
    public void init() {
        listaReservacion = beanUsuario.getServicioTecnicoService().listaPendienteReparar(beanUsuario.getUsuario());
        if (listaReservacion == null) {
            listaReservacion = new ArrayList();
        }
    }
    
    public void inicializarNuevaHistoria(){
        historia=new HistorialProductoCliente();
    }

    public void registrarNuevaReparacion() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;

        if (beanUsuario.getServicioTecnicoService().registrarEquipoReparado(beanUsuario.getUsuario(), reservacion,historia)) {

            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se realizo una nueva reparacion");
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se confirmo la reparacion");
        }
        FacesContext.getCurrentInstance().addMessage("growl_actualizacion", msg);
        if (exito) {
            String indexUsuario = "usuario_servicio_equipo_pendiente_reparar.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public void registrarNoReparacion() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;

        if (beanUsuario.getServicioTecnicoService().registrarEquipoNoReparado(beanUsuario.getUsuario(), reservacion)) {

            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "", "Se confirmo la cancelacion de la reparacion");
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se confirmo la no reparacion");
        }
        FacesContext.getCurrentInstance().addMessage("growl_actualizacion", msg);
        if (exito) {
            String indexUsuario = "usuario_servicio_equipo_pendiente_reparar.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
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

    public HistorialProductoCliente getHistoria() {
        return historia;
    }

    public void setHistoria(HistorialProductoCliente historia) {
        this.historia = historia;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
