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
@Entity
@Table(name = "tp_permiso_cliente_conf", schema = "public")
@Proxy(lazy = false)
public class ConfiguracionPermisoCliente implements Serializable{
    @Id
    @Column(name = "id_permcli_conf")
    private String id_permiso;
    @Column(name = "dnm_permcli_conf")
    private String dnombre;
    @Column(name = "nord_permcli_conf")
    private int norden;
    @Column(name = "durl_permcli_conf")
    private String durl;

    public String getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(String id_permiso) {
        this.id_permiso = id_permiso;
    }

    public String getDnombre() {
        return dnombre;
    }

    public void setDnombre(String dnombre) {
        this.dnombre = dnombre;
    }

    public int getNorden() {
        return norden;
    }

    public void setNorden(int norden) {
        this.norden = norden;
    }

    public String getDurl() {
        return durl;
    }

    public void setDurl(String durl) {
        this.durl = durl;
    }
    
}
