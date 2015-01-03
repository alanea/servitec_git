/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.TablaTipoBean;
import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.TablaTipo;
import com.eidetech.servitec.model.util.UtilTablaTipo;
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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "mantenerTablaTipo")
@ViewScoped
public class UCSYS005MantenerTablaTipoBean implements Serializable {

    private TablaTipo tabla;
    private List<TablaTipo> tablasTipo;
    private List<TablaTipo> tablasTipoFiltradas;
    private List<TablaTipo> tipoTabla;
    private List<TablaTipo> tipoTablaFiltradas;
    private List<SelectItem> siTablas;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    @ManagedProperty(value = "#{tablaTipoBean}")
    TablaTipoBean tablaTipoBean;

    /**
     * Creates a new instance of MantenerTablaTipoBean
     */
    public UCSYS005MantenerTablaTipoBean() {
        tabla = new TablaTipo();
    }

    @PostConstruct
    public void init() {
        tablasTipo = beanUsuario.getSeguridadService().obtenerTablaTipos();
        tipoTabla = UtilTablaTipo.listaTipos(tablasTipo, UtilTablaTipo.TABLA);
        siTablas = new ArrayList();
        for (TablaTipo t : tipoTabla) {
            siTablas.add(new SelectItem(t.getDtipo(), t.getDdescripcion()));
        }
        tabla.setDuserModificacion(beanUsuario.getUsuario().getDname());
    }

    public void registrarNuevoTabla() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        if (beanUsuario.getSeguridadService().registrarTabla(tabla)) {
            msg = new FacesMessage("Exito", "Se registro nueva tabla " + tabla.getDdescripcion());
            tablaTipoBean.actualizarValores();
            exito = true;
        } else {
            msg = new FacesMessage("Error", "No se pudo registrar");
        }

        FacesContext.getCurrentInstance().addMessage("usuario_mantenimiento_tabla", msg);
        if (exito) {
            String indexUsuario = "usuario_registrar_tabla.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }
    
    public void registrarNuevoTipo() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;
        
        if (beanUsuario.getSeguridadService().registrarTipo(tabla)) {
            msg = new FacesMessage("Exito", "Se registro nueva tipo " + tabla.getDdescripcion());
            tablaTipoBean.actualizarValores();
            exito = true;
        } else {
            msg = new FacesMessage("Error", "No se pudo registrar");
        }

        FacesContext.getCurrentInstance().addMessage("growl_registrar_tabla", msg);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_tipo.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public void onRowEdit(RowEditEvent event) {
        TablaTipo t = (TablaTipo) event.getObject();
        t.setDuserModificacion(beanUsuario.getUsuario().getDname());
        FacesMessage msg = new FacesMessage("TablaTipo Editado", ((TablaTipo) event.getObject()).getDdescripcion());
        if (beanUsuario.getSeguridadService().modificarTablaTipo(t)) {
            FacesContext.getCurrentInstance().addMessage("growl_modificar_tabla", msg);
        }
    }

    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edicion Cancelada", ((TablaTipo) event.getObject()).getDdescripcion());
        FacesContext.getCurrentInstance().addMessage("growl_modificar_tabla", msg);
    }

    public String descripcionTabla(String tipo) {
        return UtilTablaTipo.descripcionTipo(tipoTabla, UtilTablaTipo.TABLA, tipo);
    }

    public TablaTipo getTabla() {
        return tabla;
    }

    public void setTabla(TablaTipo tabla) {
        this.tabla = tabla;
    }

    public List<TablaTipo> getTablasTipoFiltradas() {
        return tablasTipoFiltradas;
    }

    public void setTablasTipoFiltradas(List<TablaTipo> tablasTipoFiltradas) {
        this.tablasTipoFiltradas = tablasTipoFiltradas;
    }

    public List<TablaTipo> getTipoTablaFiltradas() {
        return tipoTablaFiltradas;
    }

    public void setTipoTablaFiltradas(List<TablaTipo> tipoTablaFiltradas) {
        this.tipoTablaFiltradas = tipoTablaFiltradas;
    }

    public List<SelectItem> getSiTablas() {
        return siTablas;
    }

    public List<TablaTipo> getTablasTipo() {
        return tablasTipo;
    }

    public TablaTipoBean getTablaTipoBean() {
        return tablaTipoBean;
    }

    public void setTablaTipoBean(TablaTipoBean tablaTipoBean) {
        this.tablaTipoBean = tablaTipoBean;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public List<TablaTipo> getTipoTabla() {
        return tipoTabla;
    }

}
