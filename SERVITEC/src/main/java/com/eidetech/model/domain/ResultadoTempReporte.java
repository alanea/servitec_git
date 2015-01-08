/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eidetech.model.domain;

import java.io.Serializable;

/**
 *
 * @author laptop-w8
 */
public class ResultadoTempReporte implements Serializable {

    private String objeto;
    private int valor;

    public ResultadoTempReporte(String objeto, int valor) {
        this.objeto = objeto;
        this.valor = valor;
    }

    public ResultadoTempReporte() {
    }

    public String getObjeto() {
        return objeto;
    }

    public void setObjeto(String objeto) {
        this.objeto = objeto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj instanceof ResultadoTempReporte) {
                ResultadoTempReporte r = (ResultadoTempReporte) obj;
                return this.objeto.equals(r.getObjeto());
            }
        }
        return false;
    }

}
