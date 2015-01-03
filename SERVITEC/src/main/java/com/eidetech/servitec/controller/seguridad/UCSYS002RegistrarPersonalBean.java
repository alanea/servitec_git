/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.Personal;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.context.RequestContext;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "registrarPersonal")
@ViewScoped
public class UCSYS002RegistrarPersonalBean implements Serializable {

    private Personal personal;
    private String ubigeo_departamento;
    private String ubigeo_provincia;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSYS002RegistrarPersonalBean
     */
    public UCSYS002RegistrarPersonalBean() {
        personal = new Personal();
        personal.setDubigeo("140101");
        ubigeo_departamento = "14";
        ubigeo_provincia = "1401";
    }

    public void registrarNuevoPersonal() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage mensaje;
        boolean exito = false;

        if (beanUsuario.getSeguridadService().registrarNuevoPersonal(personal)) {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro existoso", personal.getDnombres());
            exito = true;
        } else {
            mensaje = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No se Registro ", personal.getDnombres());
        }

        FacesContext.getCurrentInstance().addMessage("growl_registro", mensaje);
        if (exito) {
            String indexUsuario = "usuario_mantenimiento_personal.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
            personal = new Personal();
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public void actualizarProvincias(final AjaxBehaviorEvent event) {
        ubigeo_provincia = "";
        personal.setDubigeo("");
    }

    public void actualizarDistritos(final AjaxBehaviorEvent event) {
        personal.setDubigeo("");
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getUbigeo_departamento() {
        return ubigeo_departamento;
    }

    public void setUbigeo_departamento(String ubigeo_departamento) {
        this.ubigeo_departamento = ubigeo_departamento;
    }

    public String getUbigeo_provincia() {
        return ubigeo_provincia;
    }

    public void setUbigeo_provincia(String ubigeo_provincia) {
        this.ubigeo_provincia = ubigeo_provincia;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
