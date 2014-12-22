/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.acceso;

import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
import com.eidetech.servitec.model.util.UtilUsuario;
import com.eidetech.servitec.service.IUsuarioService;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
    @ManagedProperty(value = "#{usuarioService}")
    IUsuarioService usuarioService;

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
        usuario = usuarioService.loginUsuarioPersonal(new UsuarioPersonal(username, password));
        if (usuario != null) {
            menuUsuarioPersonal=UtilUsuario.getMenuUsuario(usuario.getMenu());
            logeado = true;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", usuario.getDname());
        } else {
            logeado = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error", "Credenciales no válidas");
        }

        FacesContext.getCurrentInstance().addMessage(null, msg);
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

    public IUsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public MenuModel getMenuUsuarioPersonal() {
        return menuUsuarioPersonal;
    }
}
