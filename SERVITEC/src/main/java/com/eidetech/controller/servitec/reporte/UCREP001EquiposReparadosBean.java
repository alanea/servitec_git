/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.controller.servitec.reporte;

import com.eidetech.controller.seguridad.UCSYS001LoginPersonalBean;
import com.eidetech.model.domain.entity.Reservacion;
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
public class UCREP001EquiposReparadosBean implements Serializable {

    private String categoria_producto;
    private List<Reservacion> listaReparados;
    private List<Reservacion> listaReparadosFiltrado;
    @ManagedProperty(value = "#{loginPersonal}")
    private UCSYS001LoginPersonalBean beanUsuario;

    /**
     * Creates a new instance of UCSVC006ReparadosBean
     */
    public UCREP001EquiposReparadosBean() {
    }

    @PostConstruct
    public void init() {
        listaReparados = beanUsuario.getServicioTecnicoService().listaReparados();
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
