/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.cliente;

import com.eidetech.controller.seguridad.UCSYS001LoginClienteBean;
import com.eidetech.model.domain.entity.Reservacion;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "registrarOrdenCliente")
@ViewScoped
public class UCCLI001RegistrarOrdenClienteBean implements Serializable {

    private Reservacion reservacion;
    private String ubigeo_departamento;
    private String ubigeo_provincia;
    @ManagedProperty(value = "#{loginCliente}")
    private UCSYS001LoginClienteBean beanCliente;

    /**
     * Creates a new instance of UCSVC001RegistrarOrdenClienteBean
     */
    public UCCLI001RegistrarOrdenClienteBean() {
        reservacion = new Reservacion();
        reservacion.setDmarca("");
        reservacion.setDmodelo("");
        reservacion.setDubigeo("140101");
        ubigeo_departamento = "14";
        ubigeo_provincia = "1401";
    }

    public void registrarNuevaOrdenServicio() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage mensaje;
        boolean exito = false;
        
        reservacion.setCliente(beanCliente.getUsuario().getCliente());

        if (beanCliente.getServicioTecnicoService().registrarNuevoReservacion(beanCliente.getUsuario(),reservacion)) {
            beanCliente.getUsuario().getCliente().getReservaciones().add(reservacion);
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro existoso", "");
            exito = true;
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se Registro ", "");
        }

        FacesContext.getCurrentInstance().addMessage("growl_registrar_reservacion", mensaje);
        if (exito) {
            String indexUsuario = "cliente_servicios.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
            reservacion = new Reservacion();
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public void actualizarProvincias(final AjaxBehaviorEvent event) {
        ubigeo_provincia = "";
        reservacion.setDubigeo("");
    }

    public void actualizarDistritos(final AjaxBehaviorEvent event) {
        reservacion.setDubigeo("");
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public String getUbigeo_departamento() {
        return ubigeo_departamento;
    }

    public void setUbigeo_departamento(String ubigeo_departamento) {
        this.ubigeo_departamento = ubigeo_departamento;
    }

    public String getUbigeo_provincia() {
        return ubigeo_provincia;
    }

    public void setUbigeo_provincia(String ubigeo_provincia) {
        this.ubigeo_provincia = ubigeo_provincia;
    }

    public UCSYS001LoginClienteBean getBeanCliente() {
        return beanCliente;
    }

    public void setBeanCliente(UCSYS001LoginClienteBean beanCliente) {
        this.beanCliente = beanCliente;
    }

}
