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
@ManagedBean(name = "equiposReparados")
@ViewScoped
public class UCSVC006ReparadosBean implements Serializable {

    private String categoria_producto;
    private List<Reservacion> listaReparados;
    private List<Reservacion> listaReparadosFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSVC006ReparadosBean
     */
    public UCSVC006ReparadosBean() {
    }

    @PostConstruct
    public void init() {
        listaReparados = beanUsuario.getTecnicoService().listaReparados();
    }

    public String getCategoria_producto() {
        return categoria_producto;
    }

    public void setCategoria_producto(String categoria_producto) {
        this.categoria_producto = categoria_producto;
    }

    public List<Reservacion> getListaReparados() {
        return listaReparados;
    }

    public List<Reservacion> getListaReparadosFiltrado() {
        return listaReparadosFiltrado;
    }

    public void setListaReparadosFiltrado(List<Reservacion> listaReparadosFiltrado) {
        this.listaReparadosFiltrado = listaReparadosFiltrado;
    }

    public UCSYS001LoginPersonalBean getBeanUsuario() {
        return beanUsuario;
    }

    public void setBeanUsuario(UCSYS001LoginPersonalBean beanUsuario) {
        this.beanUsuario = beanUsuario;
    }

}
