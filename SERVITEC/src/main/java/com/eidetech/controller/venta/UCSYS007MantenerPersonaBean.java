/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.venta;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Persona;
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
@ManagedBean(name = "mantenerPersona")
@ViewScoped
public class UCSYS007MantenerPersonaBean implements Serializable {

    private List<Persona> listaPersona;
    private List<Persona> listaPersonaFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS007MantenerClienteBean
     */
    public UCSYS007MantenerPersonaBean() {
    }

    @PostConstruct
    public void init() {
        listaPersona = beanUsuario.getVentaService().listaPersona();
    }

    public void onRowEdit(RowEditEvent event) {
        Persona e = (Persona) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getVentaService().modificarPersona(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", e.getDnombres());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", e.getDnombres());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Persona e = (Persona) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDnombres());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public List<Persona> getListaPersona() {
        return listaPersona;
    }

    public List<Persona> getListaPersonaFiltrado() {
        return listaPersonaFiltrado;
    }

    public void setListaPersonaFiltrado(List<Persona> listaPersonaFiltrado) {
        this.listaPersonaFiltrado = listaPersonaFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
