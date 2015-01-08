/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilUsuario;
import com.eidetech.service.IRrhhService;
import com.eidetech.service.ISeguridadService;
import com.eidetech.service.IServicioTecnicoService;
import com.eidetech.service.IVentaService;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "loginPersonal")
@SessionScoped
public class UCSYS001LoginPersonalBean implements Serializable {

    private String username;
    private String password;
    private UsuarioPersonal usuario;
    private boolean logeado = false;
    private MenuModel menuUsuarioPersonal;
    @ManagedProperty(value = "#{seguridadService}")
    ISeguridadService seguridadService;
    @ManagedProperty(value = "#{servicioTecnicoService}")
    IServicioTecnicoService servicioTecnicoService;
    @ManagedProperty(value = "#{rrhhService}")
    IRrhhService rrhhService;
    @ManagedProperty(value = "#{ventaService}")
    IVentaService ventaService;

    /**
     * Creates a new instance of UCSYS001LoginUsuarioBean
     */
    public UCSYS001LoginPersonalBean() {
        menuUsuarioPersonal = new DefaultMenuModel();
        username = "";
        password = "";
    }

    public void login() {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg;
        usuario = seguridadService.loginUsuarioPersonal(new UsuarioPersonal(username, password));
        if (usuario != null) {
            menuUsuarioPersonal = UtilUsuario.getMenuUsuario(usuario.getMenu());
            logeado = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario.getDname());
        } else {
            logeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
        }

        FacesContext.getCurrentInstance().addMessage("msg", msg);
        context.addCallbackParam("estaLogeado", logeado);
        if (logeado) {
            context.addCallbackParam("view", "usuario.xhtml");
        }
    }

    public void logout() {
        HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
                .getExternalContext().getSession(false);
        session.invalidate();
        logeado = false;
    }

    public UsuarioPersonal getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioPersonal usuario) {
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

    public MenuModel getMenuUsuarioPersonal() {
        return menuUsuarioPersonal;
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

    public IRrhhService getRrhhService() {
        return rrhhService;
    }

    public void setRrhhService(IRrhhService rrhhService) {
        this.rrhhService = rrhhService;
    }

    public IVentaService getVentaService() {
        return ventaService;
    }

    public void setVentaService(IVentaService ventaService) {
        this.ventaService = ventaService;
    }
}
