/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.controller.servicio;

import com.eidetech.servitec.controller.acceso.UCSYS001LoginPersonalBean;
import com.eidetech.servitec.model.domain.entity.Reservacion;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author laptop-w8
 */
@ManagedBean(name = "equiposNoReparados")
@ViewScoped
public class UCSVC007NoReparadosBean implements Serializable{
    
    private List<Reservacion> listaNoReparados;
    private List<Reservacion> listaNoReparadosFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;
    /**
     * Creates a new instance of UCSVC007NoReparadosBean
     */
    public UCSVC007NoReparadosBean() {
    }
    @PostConstruct
    public void init() {
        listaNoReparados = beanUsuario.getTecnicoService().listaNoReparados();
    }

    public List<Reservacion> getListaNoReparados() {
        return listaNoReparados;
    }

    public List<Reservacion> getListaNoReparadosFiltrado() {
        return listaNoReparadosFiltrado;
    }

    public void setListaNoReparadosFiltrado(List<Reservacion> listaNoReparadosFiltrado) {
        this.listaNoReparadosFiltrado = listaNoReparadosFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }
    
    
}
