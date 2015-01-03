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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mantenerSubmenuPersonal")
@ViewScoped
public class UCSYS006MantenerSubmenuPersonalBean  implements Serializable{

    private List<ConfiguracionMenu> menus;
    private List<SelectItem> siMenu;
    private List<ConfiguracionSubmenu> submenus;
    private List<ConfiguracionSubmenu> submenusFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSYS006MantenerSubmenuPersonalBean
     */
    public UCSYS006MantenerSubmenuPersonalBean() {
    }
    @PostConstruct
    public void init() {
        menus = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
        submenus=UtilConfiguracion.listaSubmenu(menus);
        siMenu=listaSiMenu();
    }

    public void onRowEdit(RowEditEvent event) {
        ConfiguracionSubmenu e = (ConfiguracionSubmenu) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarConfiguracionSubmenuPersonal(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Submenu actualizado", e.getDnombre());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Submenu no actualizado", e.getDnombre());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        ConfiguracionSubmenu e = (ConfiguracionSubmenu) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDnombre());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
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

    public List<ConfiguracionSubmenu> getSubmenus() {
        return submenus;
    }

    public List<ConfiguracionSubmenu> getSubmenusFiltrado() {
        return submenusFiltrado;
    }

    public void setSubmenusFiltrado(List<ConfiguracionSubmenu> submenusFiltrado) {
        this.submenusFiltrado = submenusFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
    
}
