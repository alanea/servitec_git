/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author laptop-w8
 */
public class Reporte implements Serializable{
    public static String REPORTE_DIARIO="1";
    public static String REPORTE_MENSUAL="2";
    public static String REPORTE_ANUAL="3";
    
    private Date finicio;
    private Date ffin;
    private String dtitulo;
    private String dtipo;
    private List<ResultadoTempReporte> resultados;

    public Reporte() {
        resultados=new ArrayList();
    }
    
    public void agregarReporte(ResultadoTempReporte ar) {
        if (resultados == null) {
            resultados = new ArrayList();
        }
        resultados.add(ar);
    }

    public Date getFinicio() {
        return finicio;
    }

    public void setFinicio(Date finicio) {
        this.finicio = finicio;
    }

    public Date getFfin() {
        return ffin;
    }

    public void setFfin(Date ffin) {
        this.ffin = ffin;
    }

    public String getDtitulo() {
        return dtitulo;
    }

    public void setDtitulo(String dtitulo) {
        this.dtitulo = dtitulo;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public List<ResultadoTempReporte> getResultados() {
        return resultados;
    }

    public void setResultados(List<ResultadoTempReporte> resultados) {
        this.resultados = resultados;
    }
    
}
