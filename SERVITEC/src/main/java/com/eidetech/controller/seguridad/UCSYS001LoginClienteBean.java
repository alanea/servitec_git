/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.UsuarioCliente;
import com.eidetech.service.ISeguridadService;
import com.eidetech.service.IServicioTecnicoService;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "loginCliente")
@SessionScoped
public class UCSYS001LoginClienteBean implements Serializable{

    private String username;
    private String password;
    private UsuarioCliente usuario;
    private boolean logeado = false;
    @ManagedProperty(value = "#{seguridadService}")
    ISeguridadService seguridadService;    
    @ManagedProperty(value = "#{servicioTecnicoService}")
    IServicioTecnicoService servicioTecnicoService;
    /**
     * Creates a new instance of UCSYS001LoginClienteBean
     */
    public UCSYS001LoginClienteBean() {
        username = "";
        password = "";
    }

    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        
        UsuarioCliente u=new UsuarioCliente();
        u.setDname(username);
        u.setDpassword(password);
        usuario = seguridadService.loginUsuarioCliente(u);
        if (usuario != null) {
            logeado = true;            
            username = "";
            password = "";
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario.getDname());
        } else {
            logeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
        }

        FacesContext.getCurrentInstance().addMessage("msg", msg);
        context.addCallbackParam("estaLogeado", logeado);
        if (logeado) {
            context.addCallbackParam("view", "index.xhtml");
        }
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        logeado = false;
    }

    public UsuarioCliente getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCliente usuario) {
        this.usuario = usuario;
    }


    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ISeguridadService getSeguridadService() {
        return seguridadService;
    }

    public void setSeguridadService(ISeguridadService seguridadService) {
        this.seguridadService = seguridadService;
    }

    public IServicioTecnicoService getServicioTecnicoService() {
        return servicioTecnicoService;
    }

    public void setServicioTecnicoService(IServicioTecnicoService servicioTecnicoService) {
        this.servicioTecnicoService = servicioTecnicoService;
    }
}
