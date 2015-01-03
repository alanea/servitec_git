/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import com.eidetech.servitec.model.domain.entity.ConfiguracionPermiso;
import com.eidetech.servitec.model.domain.entity.ConfiguracionSubmenu;
import com.eidetech.servitec.model.util.UtilCadena;
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
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mantenerPermisoPersonal")
@ViewScoped
public class UCSYS006MantenerPermisoPersonalBean implements Serializable {

    private List<ConfiguracionMenu> menus;
    private List<ConfiguracionSubmenu> submenus;
    private String id_menu;
    private String id_submenu;
    private List<SelectItem> siMenu;
    private List<SelectItem> siSubmenu;
    private List<ConfiguracionPermiso> permisos;
    private List<ConfiguracionPermiso> permisosFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSYS006MantenerPermisoPersonalBean
     */
    public UCSYS006MantenerPermisoPersonalBean() {
    }
    @PostConstruct
    public void init() {
        menus = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        submenus=UtilConfiguracion.listaSubmenu(menus);
        siMenu=listaSiMenu();
        permisos=UtilConfiguracion.listaPermiso(menus);
    }
    
    public void onRowEdit(RowEditEvent event) {
        ConfiguracionPermiso e = (ConfiguracionPermiso) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarConfiguracionPermisoPersonal(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Permiso actualizado", e.getDnombre());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Permiso no actualizado", e.getDnombre());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        ConfiguracionPermiso e = (ConfiguracionPermiso) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDnombre());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }
    
    public void actualizarSubmenu(final AjaxBehaviorEvent event) {
        siSubmenu=new ArrayList();
        if(UtilCadena.cadenaValido(id_menu)){
            siSubmenu=listaSiSubmenu();
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

    private List<SelectItem> listaSiSubmenu(){
        List<SelectItem> l=new ArrayList();
        ConfiguracionMenu cm=UtilConfiguracion.obtenerMenu(menus, id_menu);
        if(cm!=null){
            for(ConfiguracionSubmenu cs:cm.getSubmenus()){
                SelectItem s=new SelectItem(cs.getId_submenu(), cs.getDnombre());
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

    public List<ConfiguracionPermiso> getPermisos() {
        return permisos;
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

    public List<ConfiguracionPermiso> getPermisosFiltrado() {
        return permisosFiltrado;
    }

    public void setPermisosFiltrado(List<ConfiguracionPermiso> permisosFiltrado) {
        this.permisosFiltrado = permisosFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
