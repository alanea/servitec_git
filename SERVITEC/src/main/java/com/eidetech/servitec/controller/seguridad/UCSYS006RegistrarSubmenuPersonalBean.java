/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.util.UtilConfiguracion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "registrarSubmenuPersonal")
@ViewScoped
public class UCSYS006RegistrarSubmenuPersonalBean implements Serializable{
    
    private List<ConfiguracionMenu> menus;
    private List<SelectItem> siMenu;
    private String id_menu;
    private ConfiguracionSubmenu configuracionSubmenu;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS006RegistrarSubmenuPersonalBean
     */
    public UCSYS006RegistrarSubmenuPersonalBean() {
        configuracionSubmenu=new ConfiguracionSubmenu();
        id_menu="";
    }
        
    @PostConstruct
    public void init() {
        menus=beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        siMenu=listaSiMenu();
    }
    
    public void registrarNuevoSubmenu(){
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        configuracionSubmenu.setMenu(UtilConfiguracion.obtenerMenu(menus, id_menu));
        
        if (beanUsuario.getSeguridadService().registrarConfiguracionSubmenuPersonal(configuracionSubmenu)) {
            msg = new FacesMessage("Exito", "Se registro nuevo menu " + configuracionSubmenu.getDnombre());
            exito = true;
        } else {
            msg = new FacesMessage("Error", "No se pudo registrar");
        }

        FacesContext.getCurrentInstance().addMessage("growl_registro", msg);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_submenu.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }
    
    private List<SelectItem> listaSiMenu(){
        List<SelectItem> l=new ArrayList();
        if(menus!=null && !menus.isEmpty()){
            for(ConfiguracionMenu c:menus){
                SelectItem s=new SelectItem(c.getId_menu(), c.getDnombre());
                l.add(s);
            }
        }
        return l;
    }

    public List<SelectItem> getSiMenu() {
        return siMenu;
    }
    
    public ConfiguracionSubmenu getConfiguracionSubmenu() {
        return configuracionSubmenu;
    }

    public void setConfiguracionSubmenu(ConfiguracionSubmenu configuracionSubmenu) {
        this.configuracionSubmenu = configuracionSubmenu;
    }

    public String getId_menu() {
        return id_menu;
    }

    public void setId_menu(String id_menu) {
        this.id_menu = id_menu;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
    
}
