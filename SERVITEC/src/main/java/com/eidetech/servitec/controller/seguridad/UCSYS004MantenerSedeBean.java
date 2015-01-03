/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.servitec.controller.seguridad;

import com.eidetech.servitec.controller.IndexBean;
import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.Sede;
import com.eidetech.servitec.model.util.UtilUbigeo;
import com.eidetech.servitec.model.util.helper.HelperSede;
import com.eidetech.servitec.model.util.validator.ValidatorSede;
import java.io.Serializable;
import javax.annotation.PostConstruct;
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
@ManagedBean(name = "mantenerSede")
@ViewScoped
public class UCSYS004MantenerSedeBean implements Serializable {

    private String ubigeo_departamento;
    private String ubigeo_provincia;
    private Sede sedeModificar;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    @ManagedProperty(value = "#{indexBean}")
    private IndexBean indexBean;

    /**
     * Creates a new instance of UCSYS004MantenerSedeBean
     */
    public UCSYS004MantenerSedeBean() {
    }

    @PostConstruct
    public void init() {
        Sede s = beanUsuario.getUsuario().getSede();
        sedeModificar = HelperSede.copiarSede(s);
        if (ValidatorSede.esValidoSede(s)) {
            if (UtilUbigeo.esValidoUbigeo(sedeModificar.getDubigeo())) {
                ubigeo_departamento = UtilUbigeo.valorUbigeoDepartamento(sedeModificar.getDubigeo());
                ubigeo_provincia = UtilUbigeo.valorUbigeoProvincia(sedeModificar.getDubigeo());
            }
        }
    }

    public void modificarSede() {
        RequestContext requestContext = RequestContext.getCurrentInstance();
        FacesMessage msg;
        boolean exito = false;

        sedeModificar.setDuserModificacion(beanUsuario.getUsuario().getDname());

        if (beanUsuario.getSeguridadService().modificarSede(sedeModificar)) {
            beanUsuario.getUsuario().setSede(sedeModificar);
            indexBean.inicializarSede();

            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Actualizado", sedeModificar.getDnombre());
            exito = true;
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No actualizado", sedeModificar.getDnombre());
        }
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);

        if (exito) {
            String indexUsuario = "usuario_mantenimiento_sede.xhtml";
            requestContext.addCallbackParam("view", indexUsuario);
            requestContext.addCallbackParam("estaRegistrado", true);
        } else {
            requestContext.addCallbackParam("estaRegistrado", false);
        }
    }

    public void actualizarProvincias(final AjaxBehaviorEvent event) {
        ubigeo_provincia = "";
        sedeModificar.setDubigeo("");
    }

    public void actualizarDistritos(final AjaxBehaviorEvent event) {
        sedeModificar.setDubigeo("");
    }

    public Sede getSedeModificar() {
        return sedeModificar;
    }

    public void setSedeModificar(Sede sedeModificar) {
        this.sedeModificar = sedeModificar;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public IndexBean getIndexBean() {
        return indexBean;
    }

    public void setIndexBean(IndexBean indexBean) {
        this.indexBean = indexBean;
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

}
