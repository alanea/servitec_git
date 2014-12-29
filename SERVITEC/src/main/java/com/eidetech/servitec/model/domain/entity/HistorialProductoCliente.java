/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
@Entity
@Table(name = "tp_historial_producto_cliente", schema = "public")
@Proxy(lazy = false)
public class HistorialProductoCliente implements Serializable{
    
    @Id
    @Column(name = "id_histprod")
    private String id_historial_producto_cliente;
    @Column(name = "dstm_histprod")
    private String dsintoma;
    @Column(name = "stmdet_histprod")
    private String dsintomaDetallado;
    @Column(name = "dtbj_histprod")
    private String dtrabajo;
    @Column(name = "dtbjdet_histprod")
    private String dtrabajoDetallado;
    @Column(name = "dusercrea_histprod")
    private String duserCreacion;
    @Column(name = "fusercrea_histprod")
    private Date fuserCreacion;
    @Column(name = "dusermod_histprod")
    private String duserModificacion;
    @Column(name = "fusermod_histprod")
    private Date fuserModificacion;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_prodcli", referencedColumnName = "id_prodcli")
    private ProductoCliente producto;   

    public String getId_historial_producto_cliente() {
        return id_historial_producto_cliente;
    }

    public void setId_historial_producto_cliente(String id_historial_producto_cliente) {
        this.id_historial_producto_cliente = id_historial_producto_cliente;
    }

    public String getDsintoma() {
        return dsintoma;
    }

    public void setDsintoma(String dsintoma) {
        this.dsintoma = dsintoma;
    }

    public String getDsintomaDetallado() {
        return dsintomaDetallado;
    }

    public void setDsintomaDetallado(String dsintomaDetallado) {
        this.dsintomaDetallado = dsintomaDetallado;
    }

    public String getDtrabajo() {
        return dtrabajo;
    }

    public void setDtrabajo(String dtrabajo) {
        this.dtrabajo = dtrabajo;
    }

    public String getDtrabajoDetallado() {
        return dtrabajoDetallado;
    }

    public void setDtrabajoDetallado(String dtrabajoDetallado) {
        this.dtrabajoDetallado = dtrabajoDetallado;
    }

    public String getDuserCreacion() {
        return duserCreacion;
    }

    public void setDuserCreacion(String duserCreacion) {
        this.duserCreacion = duserCreacion;
    }

    public Date getFuserCreacion() {
        return fuserCreacion;
    }

    public void setFuserCreacion(Date fuserCreacion) {
        this.fuserCreacion = fuserCreacion;
    }

    public String getDuserModificacion() {
        return duserModificacion;
    }

    public void setDuserModificacion(String duserModificacion) {
        this.duserModificacion = duserModificacion;
    }

    public Date getFuserModificacion() {
        return fuserModificacion;
    }

    public void setFuserModificacion(Date fuserModificacion) {
        this.fuserModificacion = fuserModificacion;
    }

    public ProductoCliente getProducto() {
        return producto;
    }

    public void setProducto(ProductoCliente producto) {
        this.producto = producto;
    }
    
    
}
