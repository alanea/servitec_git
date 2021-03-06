/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.servicio;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Reservacion;
import com.eidetech.model.util.UtilFecha;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "horarioReservaciones")
@ViewScoped
public class UCSVC001HorarioBean implements Serializable {

    private boolean esnonulo;
    private ScheduleModel modeloEventos;
    private ScheduleEvent evento = new DefaultScheduleEvent();
    private Reservacion reservacion;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSVC008HorarioBean
     */
    public UCSVC001HorarioBean() {
    }

    @PostConstruct
    public void init() {
        List<Reservacion> lista2 = beanUsuario.getServicioTecnicoService().listaPendienteRevisar();
        modeloEventos = new DefaultScheduleModel();
        if (lista2 != null && !lista2.isEmpty()) {
            for (Reservacion r : lista2) {
                DefaultScheduleEvent dse = new DefaultScheduleEvent("Pendiente revision", r.getFfecha(), UtilFecha.agregarNhorasFecha(r.getFfecha(), 1));
                dse.setData(r);
                modeloEventos.addEvent(dse);
            }
        }
    }

    public void addEvent(ActionEvent actionEvent) {
        if (evento.getId() == null) {
            modeloEventos.addEvent(evento);
        } else {
            modeloEventos.updateEvent(evento);
        }

        evento = new DefaultScheduleEvent();
    }

    public void onEventSelect(SelectEvent selectEvent) {
        evento = (ScheduleEvent) selectEvent.getObject();
        reservacion = (Reservacion) evento.getData();
        esnonulo=true;
        if(reservacion==null){
            esnonulo=false;
        }
    }

    public void onDateSelect(SelectEvent selectEvent) {
        evento = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        reservacion = (Reservacion) evento.getData();
        esnonulo=true;
        if(reservacion==null){
            esnonulo=false;
        }
    }

    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

        addMessage(message);
    }

    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public ScheduleModel getModeloEventos() {
        return modeloEventos;
    }

    public ScheduleEvent getEvento() {
        return evento;
    }

    public void setEvento(ScheduleEvent evento) {
        this.evento = evento;
    }

    public Reservacion getReservacion() {
        return reservacion;
    }

    public void setReservacion(Reservacion reservacion) {
        this.reservacion = reservacion;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

    public boolean isEsnonulo() {
        return esnonulo;
    }

    public void setEsnonulo(boolean esnonulo) {
        this.esnonulo = esnonulo;
    }

}
