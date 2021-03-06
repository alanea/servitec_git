/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.controller;

import com.eidetech.model.domain.entity.Persona;
import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.service.ISeguridadService;
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
public class UCWEB001RegistrarClienteBean implements Serializable{
    
    private Persona cliente;
    private UsuarioCliente usuario;
    @ManagedProperty(value = "#{seguridadService}")
    private ISeguridadService seguridadService;

    /**
     * Creates a new instance of UCCLI001RegistrarClienteBean
     */
    public UCWEB001RegistrarClienteBean() {
        cliente=new Persona();
        usuario=new UsuarioCliente();
    }
    
    public void registrarCliente() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage mensaje;
        boolean exito = false;
        
       usuario.setPersona(cliente);
                
        if (seguridadService.registrarUsuarioCliente(usuario)) {
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

    public ISeguridadService getSeguridadService() {
        return seguridadService;
    }

    public void setSeguridadService(ISeguridadService seguridadService) {
        this.seguridadService = seguridadService;
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
}
