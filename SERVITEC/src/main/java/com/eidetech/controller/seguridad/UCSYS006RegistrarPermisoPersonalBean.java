/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.ConfiguracionMenu;
import com.eidetech.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.model.util.UtilCadena;
import com.eidetech.model.util.UtilConfiguracion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "registrarPermisoPersonal")
@ViewScoped
public class UCSYS006RegistrarPermisoPersonalBean implements Serializable {

    private List<ConfiguracionMenu> menus;
    private List<ConfiguracionSubmenu> submenus;
    private String id_menu;
    private String id_submenu;
    private List<SelectItem> siMenu;
    private List<SelectItem> siSubmenu;
    private ConfiguracionPermiso configuracionPermiso;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS006RegistrarPermisoPersonalBean
     */
    public UCSYS006RegistrarPermisoPersonalBean() {
        configuracionPermiso = new ConfiguracionPermiso();
        id_menu = "";
        id_submenu = "";
    }

    @PostConstruct
    public void init() {
        menus = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        siMenu = listaSiMenu();
        submenus = UtilConfiguracion.listaSubmenu(menus);
        siSubmenu = listaSiSubmenu();
    }

    public void registrarNuevoPermiso() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;

        configuracionPermiso.setSubmenu(UtilConfiguracion.obtenerSubmenu(submenus, id_submenu));

        if (beanUsuario.getSeguridadService().registrarConfiguracionPermisoPersonal(configuracionPermiso)) {
            msg = new FacesMessage("Exito", "Se registro nuevo permiso " + configuracionPermiso.getDnombre());
            exito = true;
        } else {
            msg = new FacesMessage("Error", "No se pudo registrar");
        }

        FacesContext.getCurrentInstance().addMessage("growl_registro", msg);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_permiso.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public void actualizarSubmenu(final AjaxBehaviorEvent event) {
        siSubmenu = new ArrayList();
        submenus=null;
        if (UtilCadena.cadenaValido(id_menu)) {
            siSubmenu = listaSiSubmenu();
            submenus = UtilConfiguracion.listaSubmenu(menus);
        }
    }

    private List<SelectItem> listaSiMenu() {
        List<SelectItem> l = new ArrayList();
        if (menus != null && !menus.isEmpty()) {
            for (ConfiguracionMenu c : menus) {
                SelectItem s = new SelectItem(c.getId_menu(), c.getDnombre());
                l.add(s);
            }
        }
        return l;
    }

    private List<SelectItem> listaSiSubmenu() {
        List<SelectItem> l = new ArrayList();
        ConfiguracionMenu cm = UtilConfiguracion.obtenerMenu(menus, id_menu);
        if (cm != null) {
            for (ConfiguracionSubmenu cs : cm.getSubmenus()) {
                SelectItem s = new SelectItem(cs.getId_submenu(), cs.getDnombre());
                l.add(s);
            }
        }
        return l;
    }

    public List<SelectItem> getSiMenu() {
        return siMenu;
    }

    public List<SelectItem> getSiSubmenu() {
        return siSubmenu;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public String getId_submenu() {
        return id_submenu;
    }

    public void setId_submenu(String id_submenu) {
        this.id_submenu = id_submenu;
    }

    public ConfiguracionPermiso getConfiguracionPermiso() {
        return configuracionPermiso;
    }

    public void setConfiguracionPermiso(ConfiguracionPermiso configuracionPermiso) {
        this.configuracionPermiso = configuracionPermiso;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
