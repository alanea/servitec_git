/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.eidetech.servitec.model.domain.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Proxy;

/**
 *
 * @author laptop-w8
 */
//@Entity
//@Table(name = "tp_archivo", schema = "public")
//@Proxy(lazy = false)
public class Archivo implements Serializable{
    
    @Id
    @Column(name = "id_acv")
    private String id_archivo;
    @Column(name = "tip_acv")
    private String dtipo;
    @Column(name = "did_acv")
    private String did;
    @Column(name = "dcpt_acv")
    private String dcarpeta;
    @Column(name = "dnm_acv")
    private String dnombre;
    @Column(name = "bacv_acv")
    private byte[] barchivo;

    public String getId_archivo() {
        return id_archivo;
    }

    public void setId_archivo(String id_archivo) {
        this.id_archivo = id_archivo;
    }

    public String getDtipo() {
        return dtipo;
    }

    public void setDtipo(String dtipo) {
        this.dtipo = dtipo;
    }

    public String getDid() {
        return did;
    }

    public void setDid(String did) {
        this.did = did;
    }

    public String getDcarpeta() {
        return dcarpeta;
    }

    public void setDcarpeta(String dcarpeta) {
        this.dcarpeta = dcarpeta;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public byte[] getBarchivo() {
        return barchivo;
    }

    public void setBarchivo(byte[] barchivo) {
        this.barchivo = barchivo;
    }
    
    
}
