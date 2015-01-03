/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermisoCliente;
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
@ManagedBean(name = "registrarPermisoCliente")
@ViewScoped
public class UCSYS006RegistrarPermisoClienteBean implements Serializable{

    private ConfiguracionPermisoCliente permisoCliente;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSYS006RegistrarPermisoClienteBean
     */
    public UCSYS006RegistrarPermisoClienteBean() {
        permisoCliente=new ConfiguracionPermisoCliente();
    }

    public void registrarNuevoPermiso() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        if (beanUsuario.getSeguridadService().registrarConfiguracionPermisoCliente(permisoCliente)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito", "Se registro nuevo permiso " + permisoCliente.getDnombre());
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se pudo registrar");
        }

        FacesContext.getCurrentInstance().addMessage("growl_registro", msg);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_permiso_cliente.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }
    
    public ConfiguracionPermisoCliente getPermisoCliente() {
        return permisoCliente;
    }

    public void setPermisoCliente(ConfiguracionPermisoCliente permisoCliente) {
        this.permisoCliente = permisoCliente;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
