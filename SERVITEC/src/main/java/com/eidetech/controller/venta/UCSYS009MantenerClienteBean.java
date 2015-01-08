/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.venta;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Cliente;
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
@ManagedBean(name = "mantenerCliente")
@ViewScoped
public class UCSYS009MantenerClienteBean implements Serializable {

    private List<Cliente> listaCliente;
    private List<Cliente> listaClienteFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS009MantenerClienteBean
     */
    public UCSYS009MantenerClienteBean() {
    }

    @PostConstruct
    public void init() {
        listaCliente = beanUsuario.getVentaService().listaCliente();
    }

    public void onRowEdit(RowEditEvent event) {
        Cliente e = (Cliente) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getVentaService().modificarCliente(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", e.getDnombre());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", e.getDnombre());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Cliente e = (Cliente) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDnombre());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public List<Cliente> getListaCliente() {
        return listaCliente;
    }

    public List<Cliente> getListaClienteFiltrado() {
        return listaClienteFiltrado;
    }

    public void setListaClienteFiltrado(List<Cliente> listaClienteFiltrado) {
        this.listaClienteFiltrado = listaClienteFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
