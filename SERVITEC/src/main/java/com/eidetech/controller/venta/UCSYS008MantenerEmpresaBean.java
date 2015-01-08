/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.venta;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Empresa;
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
@ManagedBean(name = "mantenerEmpresa")
@ViewScoped
public class UCSYS008MantenerEmpresaBean implements Serializable {

    private List<Empresa> listaEmpresa;
    private List<Empresa> listaEmpresaFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS008MantenerEmpresaBean
     */
    public UCSYS008MantenerEmpresaBean() {
    }

    @PostConstruct
    public void init() {
        listaEmpresa = beanUsuario.getVentaService().listaEmpresa();
    }

    public void onRowEdit(RowEditEvent event) {
        Empresa e = (Empresa) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getVentaService().modificarEmpresa(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", e.getDrazonSocial());
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", e.getDrazonSocial());
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Empresa e = (Empresa) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getDrazonSocial());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public List<Empresa> getListaEmpresa() {
        return listaEmpresa;
    }

    public List<Empresa> getListaEmpresaFiltrado() {
        return listaEmpresaFiltrado;
    }

    public void setListaEmpresaFiltrado(List<Empresa> listaEmpresaFiltrado) {
        this.listaEmpresaFiltrado = listaEmpresaFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
