/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.cliente;

import com.eidetech.controller.seguridad.UCSYS001LoginClienteBean;
import java.io.Serializable;
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
@ManagedBean(name = "cambiarClave")
@ViewScoped
public class UCCLI003CambiarClaveBean implements Serializable {

    private String clave_actual;
    private String clave_nueva;
    @ManagedProperty(value = "#{loginCliente}")
    private UCSYS001LoginClienteBean beanCliente;

    /**
     * Creates a new instance of UCCLI003CambiarClaveBean
     */
    public UCCLI003CambiarClaveBean() {
    }

    public void cambiarClave() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;

        if (beanCliente.getSeguridadService().cambiarClaveUsuarioCliente(beanCliente.getUsuario(), clave_actual, clave_nueva)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Exito", "Se confirmo la actualizacion");
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se actualizo la clave");
        }
        FacesContext.getCurrentInstance().addMessage("growl_clave", msg);
        if (exito) {
            String indexUsuario = "cliente_servicios.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public String getClave_actual() {
        return clave_actual;
    }

    public void setClave_actual(String clave_actual) {
        this.clave_actual = clave_actual;
    }

    public String getClave_nueva() {
        return clave_nueva;
    }

    public void setClave_nueva(String clave_nueva) {
        this.clave_nueva = clave_nueva;
    }

    public UCSYS001LoginClienteBean getBeanCliente() {
        return beanCliente;
    }

    public void setBeanCliente(UCSYS001LoginClienteBean beanCliente) {
        this.beanCliente = beanCliente;
    }

}
