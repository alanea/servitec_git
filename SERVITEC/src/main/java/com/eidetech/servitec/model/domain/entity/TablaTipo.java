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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author usuario-xp
 */
@Entity
@Table(name = "tp_tablatipo", schema = "public")
@Proxy(lazy = false)
public class TablaTipo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tbtip")
    private int id_tabla;
    @Column(name = "dtb_tbtip")
    private String dtabla;
    @Column(name = "dtip_tbtip")
    private String dtipo;
    @Column(name = "ddesc_tbtip")
    private String ddescripcion;
    @Column(name = "dvalabrev_tbtip")
    private String dvalorAbreviado;
    @Column(name = "dusermod_tbtip")
    private String duserModificacion;
    @Column(name = "fusermod_tbtip")
    private Date fuserModificacion;

    public String toString() {
        return "TablaTipo [tabla=" + dtabla + ",tipo=" + dtipo + ",descripcion=" + ddescripcion + "]";
    }

    public TablaTipo() {
    }

    public TablaTipo(String dtabla, String dtipo, String ddescripcion) {
        this.dtabla = dtabla;
        this.dtipo = dtipo;
        this.ddescripcion = ddescripcion;
    }

    public int getId_tabla() {
        return id_tabla;
    }

    public void setId_tabla(int id_tabla) {
        this.id_tabla = id_tabla;
    }

    public String getDtabla() {
        return dtabla;
    }

    public void setDtabla(String dtabla) {
        this.dtabla = dtabla;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public String getDdescripcion() {
        return ddescripcion;
    }

    public void setDdescripcion(String ddescripcion) {
        this.ddescripcion = ddescripcion;
    }

    public String getDvalorAbreviado() {
        return dvalorAbreviado;
    }

    public void setDvalorAbreviado(String dvalorAbreviado) {
        this.dvalorAbreviado = dvalorAbreviado;
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

}
