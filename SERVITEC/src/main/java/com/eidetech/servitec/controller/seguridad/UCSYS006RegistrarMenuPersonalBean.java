/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import java.io.Serializable;
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
@ManagedBean(name = "registrarMenuPersonal")
@ViewScoped
public class UCSYS006RegistrarMenuPersonalBean implements Serializable{

    private ConfiguracionMenu configuracionMenu;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSYS005RegistrarMenuPersonalBean
     */
    public UCSYS006RegistrarMenuPersonalBean() {
        configuracionMenu=new ConfiguracionMenu();
    }

    public void registrarNuevoMenu() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        if (beanUsuario.getSeguridadService().registrarConfiguracionMenuPersonal(configuracionMenu)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO,"Exito", "Se registro nuevo menu " + configuracionMenu.getDnombre());
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "No se pudo registrar");
        }

        FacesContext.getCurrentInstance().addMessage("growl_registro", msg);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_menu.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public ConfiguracionMenu getConfiguracionMenu() {
        return configuracionMenu;
    }

    public void setConfiguracionMenu(ConfiguracionMenu configuracionMenu) {
        this.configuracionMenu = configuracionMenu;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
