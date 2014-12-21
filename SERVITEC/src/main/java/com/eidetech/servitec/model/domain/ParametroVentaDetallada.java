/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author laptop-w8
 */
public class ParametroVentaDetallada implements Serializable{
    private String moneda;
    private String formaPago;
    private String comprobanteVenta;
    private String especialidadVenta;
    private String usuarioFiltrado;
    private Date from;
    private Date to;

    public ParametroVentaDetallada() {
    }
    

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getComprobanteVenta() {
        return comprobanteVenta;
    }

    public void setComprobanteVenta(String comprobanteVenta) {
        this.comprobanteVenta = comprobanteVenta;
    }

    public String getEspecialidadVenta() {
        return especialidadVenta;
    }

    public void setEspecialidadVenta(String especialidadVenta) {
        this.especialidadVenta = especialidadVenta;
    }

    public String getUsuarioFiltrado() {
        return usuarioFiltrado;
    }

    public void setUsuarioFiltrado(String usuarioFiltrado) {
        this.usuarioFiltrado = usuarioFiltrado;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
    
}
