/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.servicio;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Reservacion;
import com.eidetech.model.domain.entity.UsuarioPersonal;
import com.eidetech.model.util.UtilLista;
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
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "asignacionTrabajo")
@ViewScoped
public class UCSVC006AsignacionTrabajoBean implements Serializable {

    private List<SelectItem> siUsuario;
    private List<UsuarioPersonal> lu;
    private List<Reservacion> listaReservacion;
    private List<Reservacion> listaReservacionFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSVC006AsignacionTrabajoBean
     */
    public UCSVC006AsignacionTrabajoBean() {
        siUsuario = new ArrayList();
    }

    @PostConstruct
    public void init() {
        listaReservacion = beanUsuario.getServicioTecnicoService().listaPendienteRevisar();
        lu = beanUsuario.getSeguridadService().listaUsuarioPersonal(beanUsuario.getUsuario().getSede());
        if (UtilLista.esValidaLista(lu)) {
            for (UsuarioPersonal up : lu) {
                SelectItem s = new SelectItem(up.getId_usuario(), up.getPersonal().getDnombres());
                siUsuario.add(s);
            }
        }
    }

    public void onRowEdit(RowEditEvent event) {
        Reservacion e = (Reservacion) event.getObject();
        FacesMessage msg;

        if (beanUsuario.getServicioTecnicoService().registrarAsignacion(e)) {
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tecnico asignado", "");
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "No asignado", "");
        }

        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }

    public void onRowCancel(RowEditEvent event) {
        Reservacion e = (Reservacion) event.getObject();
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Edicion Cancelada", e.getId_reservacion());
        FacesContext.getCurrentInstance().addMessage("growl_modificar", msg);
    }
    
    public String descripcionUsuario(String id_usuario){
        if(UtilLista.esValidaLista(lu)){
            for(UsuarioPersonal up:lu){
                if(up.getId_usuario().equals(id_usuario)){
                    return up.getPersonal().getDnombres();
                }
            }
        }
        return id_usuario;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public List<Reservacion> getListaReservacion() {
        return listaReservacion;
    }

    public List<Reservacion> getListaReservacionFiltrado() {
        return listaReservacionFiltrado;
    }

    public void setListaReservacionFiltrado(List<Reservacion> listaReservacionFiltrado) {
        this.listaReservacionFiltrado = listaReservacionFiltrado;
    }

    public List<SelectItem> getSiUsuario() {
        return siUsuario;
    }

}
