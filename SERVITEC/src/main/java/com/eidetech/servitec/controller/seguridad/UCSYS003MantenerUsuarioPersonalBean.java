/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.domain.entity.UsuarioPersonal;
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
@ManagedBean(name = "mantenerUsuarioPersonal")
@ViewScoped
public class UCSYS003MantenerUsuarioPersonalBean implements Serializable{

    private List<UsuarioPersonal> listaUsuario;
    private List<UsuarioPersonal> listaUsuarioFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSYS003MantenerUsuarioPersonalBean
     */
    public UCSYS003MantenerUsuarioPersonalBean() {
    }

    
    @PostConstruct
    public void init() {
        Sede s=beanUsuario.getUsuario().getSede();
        listaUsuario=beanUsuario.getSeguridadService().listaUsuarioPersonal(s);
    }
    
    public void onRowEdit(RowEditEvent event) {
        UsuarioPersonal e = (UsuarioPersonal) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarUsuarioPersonal(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", e.getDname());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", e.getDname());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        UsuarioPersonal e = (UsuarioPersonal) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDname());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }
    
    public List<UsuarioPersonal> getListaUsuario() {
        return listaUsuario;
    }

    public List<UsuarioPersonal> getListaUsuarioFiltrado() {
        return listaUsuarioFiltrado;
    }

    public void setListaUsuarioFiltrado(List<UsuarioPersonal> listaUsuarioFiltrado) {
        this.listaUsuarioFiltrado = listaUsuarioFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
