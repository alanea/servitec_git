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
public class ParametroVentaEspecialidadProducto implements Serializable{
    private String dsede;
    private Date finicial;
    private Date ffinal;
    private String dmodalidad;
    private String dcomprobante;

    public ParametroVentaEspecialidadProducto() {
    }

    public String getDsede() {
        return dsede;
    }

    public void setDsede(String dsede) {
        this.dsede = dsede;
    }

    public Date getFinicial() {
        return finicial;
    }

    public void setFinicial(Date finicial) {
        this.finicial = finicial;
    }

    public Date getFfinal() {
        return ffinal;
    }

    public void setFfinal(Date ffinal) {
        this.ffinal = ffinal;
    }

    public String getDmodalidad() {
        return dmodalidad;
    }

    public void setDmodalidad(String dmodalidad) {
        this.dmodalidad = dmodalidad;
    }

    public String getDcomprobante() {
        return dcomprobante;
    }

    public void setDcomprobante(String dcomprobante) {
        this.dcomprobante = dcomprobante;
    }
    
    
}
