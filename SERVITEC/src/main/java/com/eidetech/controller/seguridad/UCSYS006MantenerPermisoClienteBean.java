/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.seguridad;

import com.eidetech.model.domain.entity.ConfiguracionPermisoCliente;
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
@ManagedBean(name = "mantenerPermisoCliente")
@ViewScoped
public class UCSYS006MantenerPermisoClienteBean implements Serializable {

    private List<ConfiguracionPermisoCliente> listaPermiso;
    private List<ConfiguracionPermisoCliente> listaPermisoFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS006MantenerPermisoClienteBean
     */
    public UCSYS006MantenerPermisoClienteBean() {
    }    
    
    @PostConstruct
    public void init() {
        listaPermiso=beanUsuario.getSeguridadService().listaConfiguracionPermisoCliente();
    }

    public void onRowEdit(RowEditEvent event) {
        ConfiguracionPermisoCliente e = (ConfiguracionPermisoCliente) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarConfiguracionPermisoCliente(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado","Permiso "+ e.getDnombre());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado","Permiso "+ e.getDnombre());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        ConfiguracionPermisoCliente e = (ConfiguracionPermisoCliente) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada","Permiso "+ e.getDnombre());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public List<ConfiguracionPermisoCliente> getListaPermiso() {
        return listaPermiso;
    }

    public List<ConfiguracionPermisoCliente> getListaPermisoFiltrado() {
        return listaPermisoFiltrado;
    }

    public void setListaPermisoFiltrado(List<ConfiguracionPermisoCliente> listaPermisoFiltrado) {
        this.listaPermisoFiltrado = listaPermisoFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
