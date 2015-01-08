/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.controller.seguridad;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.UsuarioCliente;
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
@ManagedBean(name = "mantenerUsuarioCliente")
@ViewScoped
public class UCSYS002MantenerUsuarioClienteBean implements Serializable{

    private List<UsuarioCliente> listaUsuarioCliente;
    private List<UsuarioCliente> listaUsuarioClienteFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSYS010MantenerUsuarioClienteBean
     */
    public UCSYS002MantenerUsuarioClienteBean() {
    }
    
    @PostConstruct
    public void init() {
        listaUsuarioCliente=beanUsuario.getSeguridadService().listaUsuarioCliente();
    }

    public void onRowEdit(RowEditEvent event) {
        UsuarioCliente e = (UsuarioCliente) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getSeguridadService().modificarUsuarioCliente(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", e.getDname());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", e.getDname());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        UsuarioCliente e = (UsuarioCliente) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDname());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public List<UsuarioCliente> getListaUsuarioCliente() {
        return listaUsuarioCliente;
    }

    public List<UsuarioCliente> getListaUsuarioClienteFiltrado() {
        return listaUsuarioClienteFiltrado;
    }

    public void setListaUsuarioClienteFiltrado(List<UsuarioCliente> listaUsuarioClienteFiltrado) {
        this.listaUsuarioClienteFiltrado = listaUsuarioClienteFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
}
