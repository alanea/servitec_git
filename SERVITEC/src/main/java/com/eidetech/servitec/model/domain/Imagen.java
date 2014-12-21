/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain;

import java.io.Serializable;

/**
 *
 * @author laptop-w8
 */
public class Imagen implements Serializable{
    private String dnombre;

    public Imagen(String dnombre) {
        this.dnombre = dnombre;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }
    
}
