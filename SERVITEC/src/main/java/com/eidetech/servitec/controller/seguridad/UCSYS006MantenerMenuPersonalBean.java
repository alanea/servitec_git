/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.ConfiguracionMenu;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mantenerMenuPersonal")
@ViewScoped
public class UCSYS006MantenerMenuPersonalBean implements Serializable {

    private List<ConfiguracionMenu> listaMenu;
    private List<ConfiguracionMenu> listaMenuFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS006MantenerMenuPersonalBean
     */
    public UCSYS006MantenerMenuPersonalBean() {
    }

    @PostConstruct
    public void init() {
        listaMenu = beanUsuario.getSeguridadService().listaConfiguracionMenuPersonal();
    }

    public void onRowEdit(RowEditEvent event) {
        ConfiguracionMenu e = (ConfiguracionMenu) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarConfiguracionMenuPersonal(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Menu actualizado", e.getDnombre());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Menu no actualizado", e.getDnombre());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        ConfiguracionMenu e = (ConfiguracionMenu) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDnombre());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public List<ConfiguracionMenu> getListaMenu() {
        return listaMenu;
    }

    public List<ConfiguracionMenu> getListaMenuFiltrado() {
        return listaMenuFiltrado;
    }

    public void setListaMenuFiltrado(List<ConfiguracionMenu> listaMenuFiltrado) {
        this.listaMenuFiltrado = listaMenuFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
