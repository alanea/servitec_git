/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.util.converter;

import java.io.Serializable;

/**
 *
 * @author laptop-w8
 */
public class CategoriaProductoTemp implements Serializable{
    private String dcategoria;
    private String dcodigoproducto;
    private String ddescripcion;
    private String dmarca;

    public CategoriaProductoTemp() {
    }

    public String getDcategoria() {
        return dcategoria;
    }

    public void setDcategoria(String dcategoria) {
        this.dcategoria = dcategoria;
    }

    public String getDcodigoproducto() {
        return dcodigoproducto;
    }

    public void setDcodigoproducto(String dcodigoproducto) {
        this.dcodigoproducto = dcodigoproducto;
    }

    public String getDdescripcion() {
        return ddescripcion;
    }

    public void setDdescripcion(String ddescripcion) {
        this.ddescripcion = ddescripcion;
    }

    public String getDmarca() {
        return dmarca;
    }

    public void setDmarca(String dmarca) {
        this.dmarca = dmarca;
    }
    
}
