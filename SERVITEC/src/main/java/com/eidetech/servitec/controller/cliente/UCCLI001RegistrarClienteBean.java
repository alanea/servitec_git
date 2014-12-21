/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.cliente;

import com.eidetech.servitec.model.domain.entity.Cliente;
import com.eidetech.servitec.model.domain.entity.Persona;
import com.eidetech.servitec.model.domain.entity.UsuarioCliente;
import com.eidetech.servitec.service.IPortalService;
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
@ManagedBean(name = "registrarCliente")
@ViewScoped
public class UCCLI001RegistrarClienteBean implements Serializable{
    
    private Persona cliente;
    private UsuarioCliente usuario;
    private boolean recibir_email;    
    @ManagedProperty(value = "#{portalService}")
    private IPortalService portalService;

    /**
     * Creates a new instance of UCCLI001RegistrarClienteBean
     */
    public UCCLI001RegistrarClienteBean() {
        cliente=new Persona();
        usuario=new UsuarioCliente();
    }
    
    public void registrarCliente() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage mensaje;
        boolean exito = false;
        
       usuario.setPersona(cliente);
                
        if (portalService.registrarCliente(usuario)) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "REGISTRO EXITOSO", "Se ha registrado "+cliente.getDnombres()+" "+cliente.getDapellidoPaterno());
            exito = true;
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR REGISTRO", "Usted no se ha registrado");
        }
        
        FacesContext.getCurrentInstance().addMessage("registro_web_cliente", mensaje);
        if (exito) {
            String indexUsuario = "login.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public IPortalService getPortalService() {
        return portalService;
    }

    public void setPortalService(IPortalService portalService) {
        this.portalService = portalService;
    }

    public Persona getCliente() {
        return cliente;
    }

    public void setCliente(Persona cliente) {
        this.cliente = cliente;
    }

    public UsuarioCliente getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCliente usuario) {
        this.usuario = usuario;
    }

    public boolean isRecibir_email() {
        return recibir_email;
    }

    public void setRecibir_email(boolean recibir_email) {
        this.recibir_email = recibir_email;
    }

}
